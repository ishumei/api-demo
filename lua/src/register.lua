--install cjson
--install socket.http
local json = require("cjson")
hc = require('httpclient').new()
--set your own accessKey
postData = json.encode({accessKey="XXXXXXXXXXXXXXXXXXXX", data={registerTime=1477050308,tokenId="tokeId_test",ip="127.0.0.1"}})
res = hc:post('http://api.fengkongcloud.com/v2/saas/register',postData)
print(res["body"])
resJson = json.decode(res)
if resJson["code"] == 1100 then
    if resJson["riskLevel"] == "PASS" then
        --放行
    else if resJson["riskLevel"] == "REVIEW" then
        --人工审核，如果没有审核，就放行
    else if resJson["riskLevel"] == "REJECT" then
        --拒绝
    else
        --异常
    end
    end
    end
end
