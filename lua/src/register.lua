--install cjson
--install socket.http
local json = require("cjson")
hc = require('httpclient').new()
--set your own accessKey
postData = json.encode({accessKey="4Ky6AV4hE0pWLeG1bXNw", data={registerTime=1477050308,tokenId="tokeId_test",ip="127.0.0.1"}})
res = hc:post('http://api.fengkongcloud.com/v2/saas/register',postData)
print(res["body"])
