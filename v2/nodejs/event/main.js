const utils = require('../lib/utils')

const url = 'http://api-skynet-bj.fengkongcloud.com/v3/event'
const access_key = '{ACCESS_KEY}'
const event_id = 'register'

const payload = {
    'accessKey': access_key,
    'appId': 'default',
    'eventId': event_id,
    'data': {
        'tokenId': '{UID}',
        'ip': '127.0.0.1',
        'timestamp': new Date().getTime(),
    }
}

utils.sendRequest(url, 'POST', payload, data => {
    console.log(data)
})