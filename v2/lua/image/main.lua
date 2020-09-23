local json = require('cjson')
local mime = require("mime")
local hc = require('lib.httpclient').new()

local url = 'http://api-img-bj.fengkongcloud.com/v2/saas/anti_fraud/img'
local accessKey = '{ACCESS_KEY}'

local inp = assert(io.open('../files/demo.png', 'rb'))
local content = mime.b64(inp:read('*all'))

local payload = json.encode({
  accessKey = accessKey,
  type = 'DEFAULT',
  appId = 'default',
  data = {
    img = content,
    tokenId = '{UID}',
  }
})

local res = hc:post(url, payload)
local data = json.decode(res['body'])
-- 通过 code 和 riskLevel 判断返回，具体请参考接口文档
print(res['body'])
