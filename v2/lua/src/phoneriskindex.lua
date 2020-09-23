--install cjson
--install socket.http
local json = require("cjson")
hc = require('httpclient').new()
--set your own accessKey
--{"accessKey":"xxxxxxxx","data":{"phone":"xxxxxxxx","records":[{"phone":"xxxxxx","type":0,"startTime":xxxxx,"duratioin":100}],"contacts":[{"phone":"xxxxxx","name":"xxxx"}]}}
postData = json.encode({accessKey="xxxxxxxxxxxxxxxxxxxx", data={phone="18687082306",imei="352625061818645",records={{phone="18612292507",type=0,startTime=1477050308,duration=100}},contacts={{phone="18667923657",name="大志"}}}})
res = hc:post('http://api.fengkongcloud.com/v2/finance/malagent',postData)
print(res["body"])
