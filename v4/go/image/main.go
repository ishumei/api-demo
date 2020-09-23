package main

import (
	"bytes"
	"encoding/base64"
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
)

func main() {
	url := "http://api-img-bj.fengkongcloud.com/image/v4"
	accessKey := "{ACCESS_KEY}"
	uid := "{UID}"
	filename := "../files/demo.png"

	contentBytes, _ := ioutil.ReadFile(filename)
	content := base64.StdEncoding.EncodeToString(contentBytes)
	payload := map[string]interface{}{
		"accessKey": accessKey,
		"appId":     "default",
		"eventId":   "default",
		"type":      "DEFAULT",
		"data": map[string]interface{}{
			"img":     content,
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
