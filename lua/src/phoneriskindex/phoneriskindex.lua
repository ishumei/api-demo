--install cjson
--install socket.http
local json = require("cjson")
hc = require('httpclient').new()

--set your own accessKey
postData = json.encode({accessKey="xxxxx", data={phone="18687082306",imei="352625061818645",records={{phone="18612292507",type=0,startTime=1477050308,duration=100}},contacts={{phone="18667923657",name="大志"}}}})
res = hc:post('http://api.fengkongcloud.com/v2/finance/malagent',postData)
print(res["body"])

resJson = json.decode(res["body"])

-- 接口会返回code， code=1100 时说明请求成功  
-- 当 code!=1100 时，如果是 1902 错误，需要检查参数配置
-- 其余情况需要根据错误码进行重试或者其它异常处理
if resJson["code"] == 1100 then
    -- 正常业务处理
else
    -- 接口请求失败，需要参照返回码进行不同的处理
end
