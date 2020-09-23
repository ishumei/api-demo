## 示例代码说明

Lua 示例依赖 cjson 及 socket 库，请提前安装。

```shell script
luarocks install lua-cjson
luarocks install luasocket
```

请求前注意替换示例中的 Access Key，文件名及调用参数等相关信息。

```shell script
lua text/main.lua
```

返回输出：
```text
{"code":1100,"message":"\u6210\u529f","requestId":"5c8971660ac31ada34b6a484cc780040","riskLevel":"PASS","riskLabel1":"normal","riskLabel2":"","riskLabel3":"","riskDescription":"\u6b63\u5e38","riskDetail":{},"allLabels":[],"auxInfo":{}}
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
