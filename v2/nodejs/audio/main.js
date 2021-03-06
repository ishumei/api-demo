const utils = require('../lib/utils')
const fs = require('fs')

const url = 'http://api-audio-bj.fengkongcloud.com/v2/saas/anti_fraud/audio'
const access_key = '{ACCESS_KEY}'
const bt_id = '{BT_ID}'
const filename = '../files/demo.pcm'

const content = fs.readFileSync(filename, {encoding: 'base64'})
const payload = {
    'accessKey': access_key,
    'type': 'AD_PORN_POLITICAL_MOAN',
    'appId': 'default',
    'btId': bt_id,
    'callback': 'https://jsonplaceholder.typicode.com/posts/',
    'data': {
        // url 和 content 至少提供一个
        // 'url': 'https://jsonplaceholder.typicode.com/audio',
        'content': content,
        'formatInfo': {
            'format': 'pcm',
            'rate': 8000,
            'track': 1,
        },
    },
}

utils.sendRequest(url, 'POST', payload, data => {
    // 通过 code 和 riskLevel 判断返回，具体请参考接口文档
    console.log(data)
})
