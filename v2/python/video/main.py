import requests

url = 'http://api-video-bj.fengkongcloud.com/v2/saas/anti_fraud/video'
access_key = '{ACCESS_KEY}'
bt_id = '{BT_ID}'
video_url = 'https://jsonplaceholder.typicode.com/posts/'

payload = {
    'accessKey': access_key,
    'imgType': 'POLITICS_PORN_AD',
    'audioType': 'POLITICS_PORN_AD',
    'appId': 'default',
    'btId': bt_id,
    'callback': 'https://jsonplaceholder.typicode.com/posts/',
    'data': {
        'url': video_url,
    },
}

res = requests.post(url, json=payload)
# 通过 code 和 riskLevel 判断返回，具体请参考接口文档
if res:
    print(res.json())
