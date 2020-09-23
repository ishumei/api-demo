local json = require('cjson')
local hc = require('lib.httpclient').new()

local url = 'http://api-video-bj.fengkongcloud.com/v2/saas/anti_fraud/video'
local accessKey = '{ACCESS_KEY}'

local payload = json.encode({
  accessKey = accessKey,
  imgType = 'POLITICS_PORN_AD',
  audioType = 'NONE',
  appId = 'default',
  btId = '{BT_ID}',
  callback = 'https://jsonplaceholder.typicode.com/posts/',
  data = {
    url = 'https://jsonplaceholder.typicode.com/posts/',
  }
})

local res = hc:post(url, payload)
local data = json.decode(res['body'])
-- 通过 code 和 riskLevel 判断返回，具体请参考接口文档
print(res['body'])
