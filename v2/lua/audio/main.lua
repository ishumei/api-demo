local json = require('cjson')
local mime = require("mime")
local hc = require('lib.httpclient').new()

local url = 'http://api-audio-bj.fengkongcloud.com/v2/saas/anti_fraud/audio'
local accessKey = '{ACCESS_KEY}'

local inp = assert(io.open('../files/demo.pcm', 'rb'))
local content = mime.b64(inp:read('*all'))

local payload = json.encode({
  accessKey = accessKey,
  type = 'DEFAULT',
  appId = 'default',
  btId = '{BT_ID}',
  callback = 'https://jsonplaceholder.typicode.com/posts/',
  data = {
    -- url 和 content 至少提供一个
    -- url = 'https://jsonplaceholder.typicode.com/audio',
    content = content,
    formatInfo = {
      format = 'pcm',
      rate = 8000,
      track = 1,
    }
  }
})

local res = hc:post(url, payload)
local data = json.decode(res['body'])
-- 通过 code 和 riskLevel 判断返回，具体请参考接口文档
print(res['body'])
