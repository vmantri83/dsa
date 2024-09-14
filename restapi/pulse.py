import requests,json

def pulseRate(diagnosisName,doctorId):
    url='https://jsonmock.hackerrank.com/api/medical_records'
    response=requests.get(url,params={'page':1}).json()
    data=response['total_pages']
    resul=0
    k=0
    for i in range(1,data+1):
        response=requests.get(url,params={'page':i}).json()
        res=response['data']
        pageres,count=fetchdata(res,diagnosisName,doctorId)
        resul=resul+pageres
        k=k+count
    if count == 0:
        return 0  # Handle case when no matching records are found
    else:
        return (int(resul/k))

# k=0
def fetchdata(data,diagnosisName,doctorId):
    result=0
    k=0
    for i in data:
        if(i['diagnosis']['name']==diagnosisName and i['doctor']['id']==doctorId):
            result+=int(i['vitals']['pulse'])
            k=k+1
    # if(k==0):
    #     return 0
    # else:
    return result,k
    



diagnosisName=str(input())
doctorId=int(input())
print(pulseRate(diagnosisName,doctorId))