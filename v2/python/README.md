## 示例代码说明

Python 示例依赖 requests 库，请提前安装。

```shell script
pip install requests
```

请求前注意替换示例中的 Access Key，文件名及调用参数等相关信息。

```shell script
python text/main.py
```

返回输出：
```text
{'code': 1100, 'message': '成功', 'requestId': 'dbad2b151856bd1feb67c7759091eca0', 'score': 0, 'riskLevel': 'PASS', 'detail': '{"contactResult":[{"contactString":"text","contactType":3}],"description":"正常","descriptionV2":"正常","model":"M1000","riskType":0,"sexy_risk_tokenid":0}', 'status': 0}
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
