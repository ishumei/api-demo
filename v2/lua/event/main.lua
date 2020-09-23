local json = require('cjson')
local hc = require('lib.httpclient').new()

local url = 'http://api-skynet-bj.fengkongcloud.com/v3/event'
local accessKey = '{ACCESS_KEY}'
local event_id = 'register'

local payload = json.encode({
  accessKey = accessKey,
  appId = 'default',
  eventId = event_id,
  data = {
    tokenId = '{UID}',
    ip = '127.0.0.1',
    timestamp = os.time() * 1000,
  },
})

local res = hc:post(url, payload)
local data = json.decode(res['body'])
-- 通过 code 和 riskLevel 判断返回，具体请参考接口文档
print(res['body'])
