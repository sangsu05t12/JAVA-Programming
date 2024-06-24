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

room_list = []  #호텔
pri_list = []
data_frame = []
for i in range(1,3):
    w = driver.find_element(By.XPATH,'//*[@id="poduct_list_area"]/ul/li['+str(i)+']/a/div')
    w.click() 
    room_name = driver.find_elements(By.CLASS_NAME,'title')
    lis = [room.text for room in room_name]
    lis = list(filter(None, lis))
    room_list.append(lis)
    for j in range(2,len(lis)+2):
        rprice = driver.find_element(By.XPATH,'//*[@id="product_filter_form"]/article/div['+str(j)+']/div[3]/div/div/div/p[2]/b').text  #2부터시작
        pri_list.append(rprice)
    driver.back()
print(pri_list[0])
print(pri_list[1])
pri_list = [i.replace(" ","") for i in pri_list]
pri_list = [i.replace("[","") for i in pri_list]
pri_list = [i.replace("]","") for i in pri_list]
pri_list = [i.replace(",","") for i in pri_list]
pri_list = [i.replace("다른날짜확인","0원") for i in pri_list]  # 다른날짜확인 , 판매완료는 어떻게 처리할지 의논
pri_list = [i.replace("판매완료","0원") for i in pri_list]
pri_list = ''.join(pri_list)
pri_list = pri_list.split("원")

leng = len(room_list)
lengt = len(room_list[0])
for i in range(leng):
    for j in range(lengt):
        temp = []
        temp.append(room_list[i][j])
        temp.append(pri_list[i*lengt + j]+"원")  #0~15
        data_frame.append(temp)


file_name = input("파일 이름 입력 : ")
f = open(f'hotel{file_name}.csv','w',encoding='utf-8-sig',newline='')
writer = csv.writer(f)
writer.writerow(['방','가격'])
for i in data_frame:
    writer.writerow(i)
f.close()