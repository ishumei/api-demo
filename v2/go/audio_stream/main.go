package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
)

func main() {
	url := "http://api-audiostream-bj.fengkongcloud.com/v2/saas/anti_fraud/audiostream"
	accessKey := "{ACCESS_KEY}"
	streamUrl := "{URL}"
	btId := "{BT_ID}"
	uid := "{UID}"

	payload := map[string]interface{}{
		"accessKey": accessKey,
		"type":      "DEFAULT",
		"btId":      btId,
		"appId":     "default",
		"callback":  "https://jsonplaceholder.typicode.com/posts/",
		"data": map[string]interface{}{
			"url":     streamUrl,
			"tokenId": uid,
		},
	}
	b, _ := json.Marshal(payload)
	resp, _ := http.Post(url, "application/json", bytes.NewBuffer(b))

	var data map[string]interface{}
	if resp != nil {
		respBytes, _ := ioutil.ReadAll(resp.Body)
		_ = json.Unmarshal(respBytes, &data)
		// 通过 code 和 riskLevel 判断返回，具体请参考接口文档
		fmt.Println(data)
	}
}
