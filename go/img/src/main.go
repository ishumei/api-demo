package main

import (
	"encoding/base64"
	"encoding/json"
	"fmt"
	"io/ioutil"
	"lib"
	"strconv"
)

type ShumeiImgRequest struct {
	AccessKey string                 `json:"accessKey"`
	Type      string                 `json:"type"`
	Data      map[string]interface{} `json:"data"`
}

type ShumeiTextResult struct {
	Code      int                    `json:"code"`
	RiskLevel string                 `json:"riskLevel"`
	Detail    map[string]interface{} `json:"detail"`
}

func main() {
	hc := httpclient.NewHttpClient(10e9, 10e9)
	url := "http://api.fengkongcloud.com/v2/saas/anti_fraud/img"
	imageContent, err := ioutil.ReadFile("./demo.jpg")
	if err != nil {
		fmt.Println(fmt.Sprintf("Error: %v", err))
		return
	}
	imgStr := base64.StdEncoding.EncodeToString(imageContent)
	//set your own accessKey
	smtr := ShumeiImgRequest{"XXXXXXXXXXXXXXXXXX", "AD", map[string]interface{}{"tokenId": "tokenId_test", "img": imgStr}}
	bys, _ := json.Marshal(&smtr)
	header := map[string]string{"Content-Type": "application/json", "Content-Length": strconv.Itoa(len(string(bys)))}
	response, err := hc.SendPostRequest(url, header, string(bys))
	if err != nil {
		fmt.Println(fmt.Sprintf("Error: %v\n", err))
		return
	}
	fmt.Println(response)
	resJson := ShumeiTextResult{}
	err = json.Unmarshal([]byte(response), &resJson)
	if err != nil {
		fmt.Println(fmt.Sprintf("Error: %v\n", err))
		return
	}
	// success
	if resJson.Code == 1100 {
		if resJson.RiskLevel == "PASS" {
			// 放行
		} else if resJson.RiskLevel == "REVIEW" {
			// 人工审核，如果没有审核，就放行
		} else if resJson.RiskLevel == "REJECT" {
			// 拒绝
		} else {
			// 异常
		}
	}
}
