## 示例代码说明

请求前注意替换示例中的 Access Key，文件名及调用参数等相关信息。

```shell script
mvn compile
mvn exec:java -Dexec.mainClass="Text"
```

返回输出：
```text
[INFO] --- exec-maven-plugin:3.0.0:java (default-cli) @ api-demo ---
{"code":1100,"message":"成功","requestId":"530564678f69e7865374bfb7cdae44c1","riskLevel":"PASS","riskLabel1":"normal","riskLabel2":"","riskLabel3":"","riskDescription":"正常","riskDetail":{},"allLabels":[],"auxInfo":{}}
```

**类名与服务对应关系**

| 目录 | 服务 |
| --- | --- |
| Audio | 音频文件识别 |
| AudioMessage | 音频消息识别 |
| AudioStream | 音频流识别 |
| Image | 图片识别 |
| LongText | 长文本识别 |
| Text | 文本识别 |
| Video | 视频识别 |
| VideoStream| 视频流识别 |
