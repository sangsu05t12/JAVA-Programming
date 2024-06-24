from bs4 import BeautifulSoup as bs
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
import urllib.request
import click
from selenium.webdriver.common.by import By
import csv
import re  # 태그출력 제거
import numpy as np

url = 'https://www.goodchoice.kr/'
options = webdriver.ChromeOptions() 
driver = webdriver.Chrome('chromedriver')
options.add_experimental_option("excludeSwitches", ["enable-logging"])
driver = webdriver.Chrome('chromedriver',options=options)
driver.get(url)
#------------------------------------------------------------
keyword = input("검색할 지역 : ")
first = driver.find_element("xpath",'/html/body/div[1]/header/section/button[2]')
first.click()
driver.find_element("xpath",'//*[@id="keyword"]').send_keys(keyword)
driver.find_element("xpath",'//*[@id="keyword"]').send_keys(Keys.ENTER)  # 검색후
w = driver.find_element(By.XPATH,'//*[@id="content"]/div[1]/section[2]/ul/li[2]/label')
driver.execute_script("arguments[0].click();", w)
driver.find_element(By.XPATH,'//*[@id="content"]/div[1]/div[2]/button[2]').submit()

now = driver.current_url
html = urllib.request.urlopen(now).read()
soup = bs(html,'html.parser')
#------------------------------------------------------------
good = str(soup.select('p.score > span > em'))
good = re.sub('<.+?>', '', good)
good = good.replace(" ","")
good = good.replace("\n","")
good = good.replace("[","")
good = good.replace("]","")
good = good.split(',')

#------------------------------------------------------------
#txt = soup.select('strong')  # 이름
#txt = txt[7:]
txt = str(soup.select('div.name > strong'))  # 이름
txt = re.sub('<.+?>', '', txt)
txt = txt.replace(" ","")
txt = txt.replace("\n","")
txt = txt.replace("[","")
txt = txt.replace("]","")
txt = txt.split(",")

#------------------------------------------------------------
#loc = soup.select('div.name > p:nth-child(4)') #위치
loc = str(soup.select('div.name > p:nth-child(3)'))  #위치
loc = re.sub('<.+?>', '', loc)
loc = loc.replace(" ","")
loc = loc.replace("\n","")
loc = loc.replace("[","")
loc = loc.replace("]","")
loc = loc.split(",")
#------------------------------------------------------------
#방이름 , 가격별로 나누기
room_list = []
pri_list = []
data_frame = []

#------------------------------------------------------------
#csv 
leng = len(txt)
if len(txt) >= 10:
    leng = 10
for i in range(leng): # 각 장소마다 10개 뽑을거
    w = driver.find_element(By.XPATH,'//*[@id="poduct_list_area"]/ul/li['+str(i+1)+']/a/div')
    w.click() 
    room_name = driver.find_elements(By.CLASS_NAME,'title')
    lis = [room.text for room in room_name]
    lis = list(filter(None, lis))
    room_list.append(lis)

    for j in range(2,len(lis)+2):
        rprice = driver.find_element(By.XPATH,'//*[@id="product_filter_form"]/article/div['+str(j)+']/div[3]/div/div/div/p[2]').text  #2부터시작
        pri_list.append(rprice)
    driver.back()
pri_list = [i.replace(" ","") for i in pri_list]
pri_list = [i.replace("[","") for i in pri_list]
pri_list = [i.replace("]","") for i in pri_list]
pri_list = [i.replace(",","") for i in pri_list]
pri_list = [i.replace("다른날짜확인","0원") for i in pri_list]  # 다른날짜확인 , 판매완료는 어떻게 처리할지 의논
pri_list = [i.replace("판매완료","0원") for i in pri_list]
pri_list = ''.join(pri_list)
pri_list = pri_list.split("원")
pri_list = list(filter(None, pri_list))

leng = len(room_list)
sum = 0
for i in range(leng):
    temp = []
    length = len(room_list[i])
    temp.append(txt[i])
    temp.append(loc[i])
    if len(good) <=i :   
        good = []
        good.append(0.0) 
        temp.append(good[0])
    else:
        temp.append(good[i])
    if length == 0:
        room_list[i].append('방이 꽉 찼습니다.')
        temp.append(room_list[i][0])
    elif (length > 10 ):
        for j in range(10):
            temp.append(room_list[i][j])
            temp.append(pri_list[sum + j]+"원")
    else:
        for j in range(length):  
            temp.append(room_list[i][j])
            temp.append(pri_list[sum + j]+"원")
    sum = sum + length  
    data_frame.append(temp)

f = open(f'hotel_{keyword}.csv','w',encoding='utf-8-sig',newline='')
writer = csv.writer(f)
writer.writerow(['장소','위치','별점','방1','가격1','방2','가격2','방3','가격3','방4','가격4','방5','가격5','방6','가격6','방7','가격7','방8','가격8','방9','가격9','방10','가격10'])
for i in data_frame:
    writer.writerow(i)
f.close()

#이미지 출력
for i in range(leng):
    w = driver.find_element(By.XPATH,'//*[@id="poduct_list_area"]/ul/li['+str(i+1)+']/a/div')  # [1] ~ 5 
    w.click()
    w_image = driver.find_element(By.XPATH,'//*[@id="content"]/div[1]/div[1]/div[2]/div[1]/ul/li[5]/img') #[1] ~5    보여지는 이미지  둘이 같은데 위는 들어가는거, 아래는 이미지
    w_url = w_image.get_attribute('src')
    urllib.request.urlretrieve(w_url, keyword+'/hotel/image'+str(i) +'번째'+'.jpg')

    time.sleep(3) # 클릭 되기전에 꺼버려서  써줌
    length = len(room_list[i])
    if (length > 10) :
        for j in range(10):
            imagein = driver.find_element("xpath",'//*[@id="product_filter_form"]/article/div['+str(j+2)+']/div[2]/div[2]/ul/div[1]/div/div[1]/li/img')  # 리스트 2부터 시작
            img_url = imagein.get_attribute('src')
            urllib.request.urlretrieve(img_url, keyword+'/hotel/hotel'+str(i)+'번째 -'+str(j)+'.jpg')
    else:
        for j in range(length):
            if room_list[i][0] == "방이 꽉 찼습니다.":
                continue
            else:
                imagein = driver.find_element("xpath",'//*[@id="product_filter_form"]/article/div['+str(j+2)+']/div[2]/div[2]/ul/div[1]/div/div[1]/li/img')  # 리스트 2부터 시작
                img_url = imagein.get_attribute('src')
                urllib.request.urlretrieve(img_url, keyword+'/hotel/hotel'+str(i)+'번째 -'+str(j)+'.jpg')
    driver.back()
    time.sleep(3)