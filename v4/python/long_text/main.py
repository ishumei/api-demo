import requests

url = 'http://api-text-bj.fengkongcloud.com/longtext/v4'
access_key = '4Ky6AV4hE0pWLeG1bXNw'
text = '{TEXT}'
uid = '{UID}'

payload = {
    'accessKey': access_key,
    'appId': 'default',
    'eventId': 'default',
    'type': 'ALL',
    'data': {
        'text': text,
        'tokenId': uid,
    }
}

res = requests.post(url, json=payload)
# 通过 code 和 riskLevel 判断返回，具体请参考接口文档
if res:
    print(res.json())
