from bs4 import BeautifulSoup as bs
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
import urllib.request
import click
from selenium.webdriver.common.by import By

#header = {'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36'}
options = webdriver.ChromeOptions() 
options.add_argument('--headless')
options.add_argument('--no-sandbox')
options.add_argument('--disable-dev-shm-usage')
options.add_experimental_option("excludeSwitches", ["enable-logging"])
url = 'https://www.goodchoice.kr/product/search/2'
driver = webdriver.Chrome('chromedriver')
driver.get(url)
soup = bs(driver.page_source,"html.parser")
img = soup.findAll(class_='.stage.gra_black_vertical')  # 저 url 들어갔을때 사진 클래스
time.sleep(5)
#print(image1.get_attribute('src'))

for i in range(1,len(img)):
    w = driver.find_element("xpath",'//*[@id="poduct_list_area"]/li['+str(i)+']/a/div')  # [1] ~ 5
    w.click()
    time.sleep(10) # 클릭 되기전에 꺼버려서  써줌
    for j in range(5,8):
        imagein = driver.find_element("xpath",'//*[@id="content"]/div[1]/div[1]/div[2]/div[1]/ul/li['+str(j)+']/img')
        img_url = imagein.get_attribute('src')
        urllib.request.urlretrieve(img_url, 'img_data/image'+str(j)+'.jpg')
#driver.find_elements(By.CSS_SELECTOR,'.stage.gra_black_vertical')[1].send_keys(Keys.ENTER)  # [] 리스트 주기
#for i in range(1,5):  # [1]부터 시작
#    image1 = driver.find_element("xpath",'//*[@id="poduct_list_area"]/li['+str(i)+']/a/p/img') #xpath 경로  i 로 for문
    #img_url = image1.get_attribute('src')


driver.close()

#csv 
with open('hotel_text1.csv','w',encoding='utf-8-sig',newline='') as f:
   writer = csv.writer(f)
   writer.writerow(['별점'])
   writer.writerows(txt[7:])
   writer.writerows(star)
   writer.writerows(price)
   writer.writerows(loc)
   #writer.writerow(good)
   for i in good:
    writer.writerows(i)
//*[@id="product_filter_form"]/article/div[2]/div[2]/div[2]/ul/div[1]/div/div[1]/li/img
//*[@id="product_filter_form"]/article/div[3]/div[2]/div[2]/ul/div[1]/div/div[1]/li/img
for i in range(1,5):
    w = driver.find_element("xpath",'//*[@id="poduct_list_area"]/li['+str(i)+']/a/div')  # [1] ~ 5  
    w_image = driver.find_element("xpath",'//*[@id="poduct_list_area"]/li['+str(i)+']/a/p/img') #[1] ~5    보여지는 이미지  둘이 같은데 위는 들어가는거, 아래는 이미지
    w_url = w_image.get_attribute('src')
    urllib.request.urlretrieve(w_url, 'img_data/image'+str(i)+'.jpg')
    w.click()
    time.sleep(5) # 클릭 되기전에 꺼버려서  써줌
    for j in range(2,5):
        imagein = driver.find_element("xpath",'//*[@id="product_filter_form"]/article/div['+str(j)+']/div[2]/div[2]/ul/div[1]/div/div/li/img')  # 리스트 2부터 시작
        img_url = imagein.get_attribute('src')
        urllib.request.urlretrieve(img_url, 'img_data/image'+str(i)+'-'+str(j-1)+'.jpg')
    driver.back()
    time.sleep(3)
