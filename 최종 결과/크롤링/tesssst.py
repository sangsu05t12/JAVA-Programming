from bs4 import BeautifulSoup as bs
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
import urllib.request
import click
from selenium.webdriver.common.by import By
import csv
import re  # 태그출력 제거
import pandas as pd
import numpy as np

url = 'https://www.goodchoice.kr/'  #바꾸기
options = webdriver.ChromeOptions() 
#options.add_argument('--headless')
#options.add_argument('--no-sandbox')
#options.add_argument('--disable-dev-shm-usage')
options.add_experimental_option("excludeSwitches", ["enable-logging"])
driver = webdriver.Chrome('chromedriver',options=options)
driver.get(url)
html = urllib.request.urlopen(url).read()
soup = bs(html,'html.parser')

keyword = input("검색할 지역 : ")
first = driver.find_element("xpath",'/html/body/div[1]/header/section/button[2]')
first.click()
driver.find_element("xpath",'//*[@id="keyword"]').send_keys(keyword)
driver.find_element("xpath",'//*[@id="keyword"]').send_keys(Keys.ENTER)
time.sleep(5)
good = str(soup.find_all("p",class_='score')) # 한줄평
good = re.sub('<.+?>', '', good)
good = good.replace(" ","")
good = good.split(",")

txt = str(soup.select('div.name > strong'))  # 이름
txt = re.sub('<.+?>', '', txt)
txt = txt.replace(" ","")
txt = txt.split(",")
#grade = soup.select('p.score > em')  # 평점
#wow = soup.select('p.score > span')  # 평가

star = str(soup.select('div.name > div > span'))  # 별 ~성급  ~ 부티크
star = re.sub('<.+?>', '', star)
star = star.replace(" ","")
star = star.replace("[","")
star = star.replace("]","")
star = star.split(",")


price = str(soup.select('div.price > p > b'))   # 가격
price = re.sub('<.+?>', '', price)
price = price.replace(" ","")
price = price.split("원")

loc = str(soup.select('div.name > p:nth-child(4)'))  #위치
loc = re.sub('<.+?>', '', loc)
loc = loc.replace(" ","")
loc = loc.split(",")


#print(imagein.get_attribute('src'))
# 데이터프레임 별 리뷰 이름 가격 위치 , 이미지
#poduct_list_area > li:nth-child(2) > a > div > div.name > strong
#name_list = []
#price_list = []
#for i in txt:
#    name_list.append(txt[i].text.strip())
#for i in price:
#    price_list.append(price[i].text.strip())

#pensionDic = {
    #'제목' : name_list,
    #'가격' : price_list,
#    '리스트' : data_frame,
#}

#pensionDf = pd.DataFrame(pensionDic)
#pensionDf.to_csv('펜션.csv', encoding='utf-8-sig', index=False)

#print(pensionDf)
