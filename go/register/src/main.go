package main

import (
	"encoding/json"
	"fmt"
	"lib"
	"strconv"
)

type ShumeiRegisterRequest struct {
	AccessKey string                 `json:"accessKey"`
	Data      map[string]interface{} `json:"data"`
}

func main() {
	hc := httpclient.NewHttpClient(1e9, 1e9)
	url := "http://api.fengkongcloud.com/v2/saas/register"
	//set your own accessKey
	smtr := ShumeiRegisterRequest{"4Ky6AV4hE0pWLeG1bXNw", map[string]interface{}{"tokenId": "tokenId_test", "registerTime": 1477034623, "ip": "127.0.0.1"}}
	bys, _ := json.Marshal(&smtr)
	header := map[string]string{"Content-Type": "application/json", "Content-Length": strconv.Itoa(len(string(bys)))}
	response, err := hc.SendPostRequest(url, header, string(bys))
	if err != nil {
		fmt.Println(fmt.Sprintf("Error: %v\n", err))
		return
	}
	fmt.Println(response)
}
