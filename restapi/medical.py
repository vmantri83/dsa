import requests
import json


def getResponse(low,high):
    url='https://jsonmock.hackerrank.com/api/medical_records'
    req=requests.get(url, params={'page': 9}) # this is an alternative way to write the url with params rather than hard coding it
    # req=requests.get(url)
    request=req.json()
    data=request['data']
    total=request['total_pages']
    # print(request)
    # getCount(low,high,data)
    # ans=[]
    c=0
    for j in range(1,total+1):
        # print(j)
        c=c+getCount(low,high,requests.get(url, params={'page': j}).json())
    return c
    
    
def getCount(low,high,data):
    count=0
    # print(data)
    data=data['data']
    for i in data:
        if(int(i['vitals']['bloodPressureDiastole'])<=high and int(i['vitals']['bloodPressureDiastole'])>=low):
            count=count+1
    # print(req.json())
    return count



low=int(input())
high=int(input())
print(getResponse(low,high))