## 示例代码说明

请求前注意替换示例中的 Access Key，文件名及调用参数等相关信息。

```shell script
go run text/main.go
```

返回输出：
```text
map[code:1100 detail:{"contactResult":[{"contactString":"text","contactType":3}],"description":"正常","descriptionV2":"正常","model":"M1000","riskType":0,"sexy_risk_tokenid":0} message:成功 requestId:e5c699c6c2a016476d9310a925f25e74 riskLevel:PASS score:0 status:0]
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
