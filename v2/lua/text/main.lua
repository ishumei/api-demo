local json = require('cjson')
local hc = require('lib.httpclient').new()

local url = 'http://api-text-bj.fengkongcloud.com/v2/saas/anti_fraud/text'
local accessKey = '{ACCESS_KEY}'

local payload = json.encode({
  accessKey = accessKey,
  type = 'SOCIAL',
  appId = 'default',
  data = {
    text = '{TEXT}',
    tokenId = '{UID}',
  },
})

local res = hc:post(url, payload)
local data = json.decode(res['body'])
-- 通过 code 和 riskLevel 判断返回，具体请参考接口文档
print(res['body'])
