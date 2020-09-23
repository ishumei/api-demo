local json = require('cjson')
local hc = require('lib.httpclient').new()

local url = 'http://api-audiostream-bj.fengkongcloud.com/v2/saas/anti_fraud/audiostream'
local accessKey = '{ACCESS_KEY}'

local payload = json.encode({
  accessKey = accessKey,
  type = 'DEFAULT',
  btId = '{BT_ID}',
  appId = 'default',
  callback = 'https://jsonplaceholder.typicode.com/posts/',
  data = {
    url = '{URL}',
    tokenId = '{UID}',
  }
})

local res = hc:post(url, payload)
local data = json.decode(res['body'])
-- 通过 code 和 riskLevel 判断返回，具体请参考接口文档
print(res['body'])
