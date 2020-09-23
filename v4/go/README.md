## 示例代码说明

请求前注意替换示例中的 Access Key，文件名及调用参数等相关信息。

```shell script
go run text/main.go
```

返回输出：
```text
map[allLabels:[] auxInfo:map[] code:1100 message:成功 requestId:de9d26a0058e7ee9fc818977eed21241 riskDescription:正常 riskDetail:map[] riskLabel1:normal riskLabel2: riskLabel3: riskLevel:PASS]
```

**目录与服务对应关系**

| 目录 | 服务 |
| --- | --- |
| audio | 音频文件识别 |
| audio_message | 音频消息识别 |
| audio_stream | 音频流识别 |
| image | 图片识别 |
| long_text | 长文本识别 |
| text | 文本识别 |
| video | 视频识别 |
| video_stream| 视频流识别 |
