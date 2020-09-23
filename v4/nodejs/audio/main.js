const utils = require('../lib/utils')
const fs = require('fs')

const url = 'http://api-audio-bj.fengkongcloud.com/audio/v4'
const access_key = '{ACCESS_KEY}'
const bt_id = '{BT_ID}'
const filename = '../files/demo.pcm'

const content = fs.readFileSync(filename, {encoding: 'base64'})
const payload = {
    'accessKey': access_key,
    'appId': 'default',
    'eventId': 'audio',
    'type': 'DEFAULT',
    'contentType': 'RAW',
    'content': content,
    'btId': bt_id,
    'callback': 'https://jsonplaceholder.typicode.com/posts/',
    'data': {
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