import requests
import json

def getResponse(city,pageno,max):
    # url='https://jsonmock.hackerrank.com/api/food_outlets'
    url='https://jsonmock.hackerrank.com/api/food_outlets?city='+city+'&page='+pageno
    # response=requests.get(url, params={'city': city, 'page':pageno})
    response=requests.get(url)
    result=response.json()
    res=result['data']
    ans=[]
    for i in res:
        if(int(i['estimated_cost'])<=max):
            ans.append(i)
    return ans

city=input()
pageno=input()
max=int(input())
print(getResponse(city,pageno,max))