const utils = require('../lib/utils')

const url = 'http://api-video-bj.fengkongcloud.com/v2/saas/anti_fraud/video'
const access_key = '{ACCESS_KEY}'
const bt_id = '{BT_ID}'
const video_url = 'https://jsonplaceholder.typicode.com/posts/'

const payload = {
    'accessKey': access_key,
    'imgType': 'POLITICS_PORN_AD',
    'audioType': 'NONE',
    'appId': 'default',
    'btId': bt_id,
    'callback': 'https://jsonplaceholder.typicode.com/posts/',
    'data': {
        'url': video_url,
    },
}

utils.sendRequest(url, 'POST', payload, data => {
    // 通过 code 和 riskLevel 判断返回，具体请参考接口文档
    console.log(data)
})