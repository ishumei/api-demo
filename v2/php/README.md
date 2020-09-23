## 示例代码说明

请求前注意替换示例中的 Access Key，文件名及调用参数等相关信息。

```shell script
php text/main.php
```

返回输出：
```text
object(stdClass)#1 (7) {
  ["code"]=>
  int(1100)
  ["message"]=>
  string(6) "成功"
  ["requestId"]=>
  string(32) "832287c9db58d36c6033812fcd243173"
  ["score"]=>
  int(0)
  ["riskLevel"]=>
  string(4) "PASS"
  ["detail"]=>
  string(159) "{"contactResult":[{"contactString":"text","contactType":3}],"description":"正常","descriptionV2":"正常","model":"M1000","riskType":0,"sexy_risk_tokenid":0}"
  ["status"]=>
  int(0)
}
```

**目录与服务对应关系**

| 目录 | 服务 |
| --- | --- |
| audio | 音频文件识别 |
| audio_stream | 音频流识别 |
| event | 天网事件 |
| image | 图片识别 |
| text | 文本识别 |
| video | 视频识别 |
| video_stream| 视频流识别 |
