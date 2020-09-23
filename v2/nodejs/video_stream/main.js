const utils = require('../lib/utils')

const url = 'http://api-videostream-bj.fengkongcloud.com/v3/saas/anti_fraud/videostream'
const access_key = '{ACCESS_KEY}'
const uid = '{UID}'
const video_url = 'https://jsonplaceholder.typicode.com/posts/'

const payload = {
    'accessKey': access_key,
    'appId': 'default',
    'imgType': 'POLITICS_PORN_AD',
    'audioType': 'NONE',
    'imgCallback': 'https://jsonplaceholder.typicode.com/posts/',
    'data': {
        'streamType': 'NORMAL',
        'tokenId': uid,
        'url': video_url,
    },
}

utils.sendRequest(url, 'POST', payload, data => {
    // 通过 code 和 riskLevel 判断返回，具体请参考接口文档
    console.log(data)
})