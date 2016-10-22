package main

import (
	"encoding/json"
	"fmt"
	"lib"
	"strconv"
)

type ShumeiTextRequest struct {
	AccessKey string                 `json:"accessKey"`
	Type      string                 `json:"type"`
	Data      map[string]interface{} `json:"data"`
}

func main() {
	hc := httpclient.NewHttpClient(1e9, 1e9)
	url := "http://api.fengkongcloud.com/v2/saas/anti_fraud/text"
	//set your own accessKey
	smtr := ShumeiTextRequest{"xxxxxxxxxxxxxxxxxxxx", "ZHIBO", map[string]interface{}{"tokenId": "tokenId_test", "text": "iphone 7"}}
	bys, _ := json.Marshal(&smtr)
	header := map[string]string{"Content-Type": "application/json", "Content-Length": strconv.Itoa(len(string(bys)))}
	response, err := hc.SendPostRequest(url, header, string(bys))
	if err != nil {
		fmt.Println(fmt.Sprintf("Error: %v\n", err))
		return
	}
	fmt.Println(response)
}
