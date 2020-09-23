local json = require('cjson')
local hc = require('lib.httpclient').new()

local url = 'http://api-videostream-bj.fengkongcloud.com/v3/saas/anti_fraud/videostream'
local accessKey = '{ACCESS_KEY}'

local payload = json.encode({
  accessKey = accessKey,
  appId = 'default',
  imgType = 'POLITICS_PORN_AD',
  audioType = 'NONE',
  imgCallback = 'https://jsonplaceholder.typicode.com/posts/',
  data = {
    streamType = 'NORMAL',
    tokenId = '{UID}',
    url = 'https://jsonplaceholder.typicode.com/posts/',
  }
})

local res = hc:post(url, payload)
local data = json.decode(res['body'])
-- 通过 code 和 riskLevel 判断返回，具体请参考接口文档
print(res['body'])
