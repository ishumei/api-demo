--install cjson
--install socket.http
local json = require("cjson")
local mime = require("mime")
hc = require('httpclient').new()
local inp = assert(io.open("./demo.jpg","rb"))
local content = inp:read("*all")
imgStr = mime.b64(content)
--set your own accessKey
postData = json.encode({accessKey="XXXXXXXXXXXXXXXXX", type="AD", data={tokenId="tokeId_test",img=imgStr}})
res = hc:post('http://api.fengkongcloud.com/v2/saas/anti_fraud/img',postData)
print(res["body"])
