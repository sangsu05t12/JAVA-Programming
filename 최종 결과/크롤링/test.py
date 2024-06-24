import urllib.request
from urllib.request import urlretrieve
from bs4 import BeautifulSoup
import csv

hdr = {'User-Agent' : 'Mozilla/5.0'}
url = 'https://www.goodchoice.kr/product/search/2'
imgurl = 'https://www.goodchoice.kr/product/detail?ano=13067&adcno=2&sel_date=2022-11-04&sel_date2=2022-11-05'  # 이미지 url
html = urllib.request.urlopen(url).read()
imghtml = urllib.request.urlopen(imgurl).read()  # 이미지 html
soup = BeautifulSoup(html,'html.parser')
imgsoup = BeautifulSoup(imghtml, 'html.parser')   # 이미지 soup
img = imgsoup.findAll('img')

#txt = soup.select('strong')
#star = soup.select('.score')

#print(txt)
#print(star)

#with open('hotel_text.csv','w',encoding='utf-8',newline='') as f:
 #   writer = csv.writer(f)
  #  writer.writerow(['별점'])
#
 #   #writer.writerows(txt[7:])
  #  writer.writerows(star)

for i in range(len(img)):
    imgu = img[i].attrs['src']
    with open(imgu,mode="wb") as f:
      f.write(imgu)
      urlretrieve(imgu, '{}.jpg'.format(i))