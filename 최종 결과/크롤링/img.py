from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from urllib.request import urlretrieve
from urllib.request import urlopen
from bs4 import BeautifulSoup as bs
import time
import requests

header = {'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36'}
url = 'https://www.goodchoice.kr/product/search/2'
options = webdriver.ChromeOptions() 
options.add_argument('--headless')
options.add_argument('--no-sandbox')
options.add_argument('--disable-dev-shm-usage')
options.add_experimental_option("excludeSwitches", ["enable-logging"])
driver = webdriver.Chrome(executable_path="chromedriver.exe", options=options)
html = requests.get(url, headers = header)
#print(driver)
time.sleep(10)
#html = driver.page_source
soup = bs(html.content,"lxml")
img = soup.findAll(class_='.lazy.align')


for i in range(len(img)): 
    img_src = img[i].get_attribute['src']
    #b = i.a['src']
    urlretrieve(img_src, str (i) + ".jpg")
    print(img_src)
driver.close()