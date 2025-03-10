const utils = require('../lib/utils')
const fs = require('fs')

const url = 'http://api-img-bj.fengkongcloud.com/v2/saas/anti_fraud/img'
const access_key = '{ACCESS_KEY}'
const uid = '{UID}'
const filename = '../files/demo.png'

const content = fs.readFileSync(filename, {encoding: 'base64'})
const payload = {
    'accessKey': access_key,
    'type': 'POLITICS_PORN_AD_BEHAVIOR',
    'appId': 'default',
    'data': {
        'img': content,
        'tokenId': uid,
    }
}

utils.sendRequest(url, 'POST', payload, data => {
    // 通过 code 和 riskLevel 判断返回，具体请参考接口文档
    console.log(data)
})
