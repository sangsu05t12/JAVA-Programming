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
tab = driver.find_element(By.ID,'tabView3').click()  # 축제 버튼
new = driver.find_element(By.ID, '2').click() # 최신순 클릭

name_list = []
place_list = []
day_list = []

for i in range(11):  
    if i == 4:  # 광고창 스킵
        continue
    trs = driver.find_element(By.XPATH, '//*[@id="listBody"]/ul/li['+str(i+1)+']/div[1]/a')
    driver.execute_script("arguments[0].click();", trs)
    time.sleep(2)
    nametxt = driver.find_element(By.ID, 'topTitle')
    ntxt = nametxt.text
    time.sleep(1)
    place = driver.find_element(By.XPATH, '//*[@id="topAddr"]/span[1]')
    ptxt = place.text
    day = driver.find_element(By.XPATH, '//*[@id="topAddr"]/span[2]')
    dtxt = day.text
    ing = driver.find_element(By.XPATH, '//*[@id="contents"]/div[1]/div[2]/span')
    ingtxt = ing.text
    image = driver.find_element(By.XPATH , '//*[@id="pImgList"]/div[1]/img')
    w_url = image.get_attribute('src')
    time.sleep(1)
    
    if (ingtxt == "진행중"):
        name_list.append(ntxt)
        place_list.append(ptxt)
        day_list.append(dtxt)
        urllib.request.urlretrieve(w_url, keyword+'/festival/festival'+str(i+1)+'번째'+'.jpg')
        driver.back()
    elif (ingtxt == "진행전"):
        name_list.append(ntxt)
        place_list.append(ptxt)
        day_list.append(dtxt)
        urllib.request.urlretrieve(w_url, keyword+'/festival/festival'+str(i+1)+'번째'+'.jpg')
        driver.back()
    else:
        driver.back()
    time.sleep(1)

num = len(name_list)
data_frame = []
for i in range(num):
    temp = []
    temp.append(name_list[i])
    temp.append(place_list[i])
    temp.append(day_list[i])
    data_frame.append(temp)
if (data_frame == []):
    print("축제가 없습니다.")
else:
    f = open(f'festival_{keyword}.csv','w',encoding='utf-8-sig',newline='')
    writer = csv.writer(f)
    writer.writerow(['이름','위치', '기간'])
    for i in data_frame:
        writer.writerow(i)
    f.close()