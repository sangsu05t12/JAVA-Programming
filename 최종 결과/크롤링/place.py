from bs4 import BeautifulSoup as bs
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
import urllib.request
import click
from selenium.webdriver.common.by import By
import csv
import numpy as np

url = 'https://korean.visitkorea.or.kr/search/search_list.do?keyword='
keyword = input("검색할 지역 : ")
base_url = url + keyword

options = webdriver.ChromeOptions() 
driver = webdriver.Chrome('chromedriver')
options.add_experimental_option("excludeSwitches", ["enable-logging"])
driver = webdriver.Chrome('chromedriver',options=options)
driver.get(base_url)
tab = driver.find_element(By.ID,'tabView1').click()  # 여행정보

name_list = []
place_list = []

for i in range(11):  
    if i == 4:  # 광고창 스킵
        continue
    time.sleep(1)
    name = driver.find_element(By.XPATH, '//*[@id="listBody"]/ul/li['+str(i+1)+']/div[2]/div[1]/a')
    nametxt = name.text
    name_list.append(nametxt)

    place = driver.find_element(By.XPATH, ' //*[@id="listBody"]/ul/li['+str(i+1)+']/div[2]/div[2]/p')
    placetxt = place.text
    place_list.append(placetxt)
    image = driver.find_element(By.XPATH, '//*[@id="listBody"]/ul/li['+str(i+1)+']/div[1]/a/img')
    w_url = image.get_attribute('src')
    urllib.request.urlretrieve(w_url, keyword+'/place/place'+str(i+1)+'번째'+'.jpg')
    time.sleep(1)

data_frame = []
num = len(name_list)

for i in range(num):
    temp = []
    temp.append(name_list[i])
    temp.append(place_list[i])
    data_frame.append(temp)

f = open(f'place_{keyword}.csv','w',encoding='utf-8-sig',newline='')
writer = csv.writer(f)
writer.writerow(['이름','위치'])
for i in data_frame:
    writer.writerow(i)
f.close()