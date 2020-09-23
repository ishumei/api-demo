--install cjson
--install socket.http
local json = require("cjson")
hc = require('httpclient').new()

--set your own accessKey
postData = json.encode({accessKey="xxxxxxx", type="ZHIBO", data={tokenId="tokeId_test",text="iphone 7"}})
res = hc:post('http://api.fengkongcloud.com/v2/saas/anti_fraud/text',postData)
print(res["body"])

resJson = json.decode(res['body'])

-- 接口会返回code， code=1100 时说明请求成功，根据不同的 riskLevel 风险级别进行业务处理  
-- 当 code!=1100 时，如果是 1902 错误，需要检查参数配置
-- 其余情况需要根据错误码进行重试或者其它异常处理
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
else
    -- 接口请求失败，需要参照返回码进行不同的处理
end
