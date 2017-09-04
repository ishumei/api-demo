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

type ShumeiTextResult struct {
	Code      int                    `json:"code"`
	RiskLevel string                 `json:"riskLevel"`
	Detail    map[string]interface{} `json:"detail"`
}

func main() {
	hc := httpclient.NewHttpClient(2e9, 5e9)
	url := "http://api.fengkongcloud.com/v2/saas/register"
	//set your own accessKey
	smtr := ShumeiRegisterRequest{"xxxxxx", map[string]interface{}{"tokenId": "tokenId_test", "registerTime": 1477034623, "ip": "127.0.0.1"}}
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

	/**
	 * 接口会返回code， code=1100 时说明请求成功，根据不同的 riskLevel 风险级别进行业务处理
	 * 当 code!=1100 时，如果是 1902 错误，需要检查参数配置
	 * 其余情况需要根据错误码进行重试或者其它异常处理
	 */
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
	} else {
		// 接口请求失败，需要参照返回码进行不同的处理
	}
}
