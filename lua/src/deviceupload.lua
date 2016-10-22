--install cjson
--install socket.http
local json = require("cjson")
hc = require('httpclient').new()
--set your own accessKey
postData = json.encode({organization="xxxxxxxxxxxxxxxxxxxx", data={fingerprint="866657020185815",sessionId="1234567890"}})
res = hc:post('http://fp.fengkongcloud.com/v1/profile',postData)
print(res["body"])
