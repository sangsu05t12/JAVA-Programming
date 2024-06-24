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
w = driver.find_element(By.XPATH,'//*[@id="content"]/div[1]/section[2]/ul/li[1]/label')
driver.execute_script("arguments[0].click();", w)
driver.find_element(By.XPATH,'//*[@id="content"]/div[1]/div[2]/button[2]').submit()
now = driver.current_url
html = urllib.request.urlopen(now).read()
soup = bs(html,'html.parser')
#------------------------------------------------------------
#txt = soup.select('strong')  # 이름
#txt = txt[7:]
txt = str(soup.select('div.name > strong'))  # 이름
txt = re.sub('<.+?>', '', txt)
txt = txt.replace("\n","")
txt = txt.replace(" ","")
txt = txt.replace("[","")
txt = txt.replace("]","")
txt = txt.split(",")
time.sleep(1)
#------------------------------------------------------------
#대실
price = str(soup.select('div > div.price > p:nth-child(2) > b'))   # 가격 
price = re.sub('<.+?>', '', price)
price = price.replace(" ","")
price = price.replace("[","")
price = price.replace("]","")
price = price.replace(",","")
price = price.replace("다른날짜확인","0원")  
price = price.replace("판매완료","0원")
price = price.replace("숙소에문의","0원")
price = price.split("원")
#------------------------------------------------------------
#숙박
price2 = str(soup.select('div.price > p:nth-child(3) > b'))   # 가격  
price2 = re.sub('<.+?>', '', price2)
price2 = price2.replace(" ","")
price2 = price2.replace("[","")
price2 = price2.replace("]","")
price2 = price2.replace(",","")
price2 = price2.replace("다른날짜확인","0원")
price2 = price2.replace("판매완료","0원")
price2 = price2.replace("숙소에문의","0원")
price2 = price2.split("원")
time.sleep(1)
#------------------------------------------------------------
#loc = soup.select('div.name > p:nth-child(4)') #위치
loc = str(soup.select('div.name > p:nth-child(3)'))  #위치
loc = re.sub('<.+?>', '', loc)
loc = loc.replace(" ","")
loc = loc.replace("\n","")
loc = loc.replace("[","")
loc = loc.replace("]","")
loc = loc.split(",")
time.sleep(1)
#------------------------------------------------------------
#good = str(soup.find_all("p",class_='score')) # 한줄평
good = str(soup.select('p.score > span > em'))
good = re.sub('<.+?>', '', good)
good = good.replace(" ","")
good = good.replace("\n","")
good = good.replace("[","")
good = good.replace("]","")
good = good.split(",")
time.sleep(1)
#------------------------------------------------------------
#csv 
print("-----------------------------------")
data_frame = []

leng = len(txt)
if len(txt) >= 10:
    leng = 10
for i in range(leng): # 각 장소마다 10개 뽑을거
    temp = []
    temp.append(txt[i])
    temp.append(price[i]+"원")
    temp.append(price2[i]+"원")
    temp.append(loc[i])
    temp.append(good[i])
    data_frame.append(temp)


f = open(f'motel_{keyword}.csv','w',encoding='utf-8-sig',newline='')
writer = csv.writer(f)
writer.writerow(['장소','대실','숙박','위치','별점'])
for i in data_frame:
    writer.writerow(i)
f.close()


#이미지 출력
for i in range(leng):
    w = driver.find_element(By.XPATH,'//*[@id="poduct_list_area"]/ul/li['+str(i+1)+']/a/div')  # 클릭
    w.click()
    imagein = driver.find_element(By.XPATH,'//*[@id="content"]/div[1]/div[1]/div[2]/div[1]/ul/li[5]/img')
    img_url = imagein.get_attribute('src')
    urllib.request.urlretrieve(img_url, keyword+'/motel/motel'+str(i) + '번째'+'.jpg')
    driver.back()
