--install cjson
--install socket.http
local json = require("cjson")
hc = require('httpclient').new()
--set your own accessKey
postData = json.encode({accessKey="xxxxxxxxxxxxxxxxxxxx", type="ZHIBO", data={tokenId="tokeId_test",text="iphone 7"}})
res = hc:post('http://api.fengkongcloud.com/v2/saas/anti_fraud/text',postData)
print(res["body"])
