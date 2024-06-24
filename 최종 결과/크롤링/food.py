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

url = 'https://www.siksinhot.com/search?keywords='
keyword = input("검색할 단어 : ")
base_url = url + keyword
options = webdriver.ChromeOptions() 
driver = webdriver.Chrome('chromedriver')
options.add_experimental_option("excludeSwitches", ["enable-logging"])
driver = webdriver.Chrome('chromedriver',options=options)
driver.get(base_url)

now = driver.current_url
html = urllib.request.urlopen(now).read()
soup = bs(html,'html.parser')


info = str(soup.select('a > h2'))  # 이름
info = re.sub('<.+?>', '', info)
info = info.replace(" ","")
info = info.replace("[","")
info = info.replace("]","")
info = info.split(",")

star = str(soup.select('figcaption > a > span'))
star = re.sub('<.+?>', '', star)
star = star.replace(" ","")
star = star.replace("[","")
star = star.replace("]","")
star = star.split(",")

visit = str(soup.select('p.cate > a:nth-child(1)'))
visit = re.sub('<.+?>', '', visit)
visit = visit.replace(" ","")
visit = visit.replace("[","")
visit = visit.replace("]","")
visit = visit.split(",")

kind = str(soup.select('p.cate > a:nth-child(2)'))
kind = re.sub('<.+?>', '', kind)
kind = kind.replace(" ","")
kind = kind.replace("[","")
kind = kind.replace("]","")
kind = kind.split(",")

print("-----------------------------------")
data_frame = []

for i in range(5):
    temp = []
    temp.append(info[i])
    temp.append(star[i]+"점")
    temp.append(visit[i])
    temp.append(kind[i])
    data_frame.append(temp)

f = open(f'food_{keyword}.csv','w',encoding='utf-8-sig',newline='')
writer = csv.writer(f)
writer.writerow(['이름','별점','위치','종류'])
for i in data_frame:
    writer.writerow(i)
f.close()
#//*[@id="main_search"]/div/article[1]/section/div/div/ul/li[1]/figure/a/img[1]  제주도
#//*[@id="main_search"]/div/article[1]/section/div[2]/div/ul/li[1]/figure/a/img[1]
#//*[@id="main_search"]/div/article[1]/section/div[2]/div/ul/li[1]/figure/a/img[1]
#//*[@id="main_search"]/div/article[1]/section/div/div/ul/li[3]/figure/a/img[1]

for i in range(5):
    image = driver.find_element(By.XPATH, '//*[@id="main_search"]/div/article[1]/section/div[2]/div/ul/li['+str(i+1)+']/figure/a/img[1]')
    image_src = image.get_attribute('src')
    urllib.request.urlretrieve(image_src, keyword+'/food/food'+str(i)+'번째'+'.jpg')
