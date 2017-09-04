/**
 * 运行本demo，运行 sh run.sh 即可
**/

package main

import (
	"encoding/json"
	"fmt"
	"lib"
	"strconv"
)

type SContact struct {
	Phone string `json:"phone"`
	Name  string `json:"name"`
}
type SRecord struct {
	Phone     string `json:"phone"`
	Type      int    `json:"type"`
	StartTime int    `json:"startTime"`
	Duration  int    `json:"duration"`
}
type SPRIReqData struct {
	Phone    string     `json:"phone"`
	Imei     string     `json:"imei"`
	Records  []SRecord  `json:"records"`
	Contacts []SContact `json:"contacts"`
}
type ShumeiPRIRequest struct {
	AccessKey string      `json:"accessKey"`
	Data      SPRIReqData `json:"data"`
}
type ShumeiFMResult struct {
	Code      int                    `json:"code"`
	Message   string                 `json:"message"`
	RequestId string                 `json:"requestId"`
	Detail    map[string]interface{} `json:"detail"`
}

func main() {
	hc := httpclient.NewHttpClient(2e9, 5e9)
	url := "http://finance-api.fengkongcloud.com/v2/finance/malagent"
	contacts := []SContact{SContact{"18687908768", "大志"}}            // 设置 contacts 数组
	records := []SRecord{SRecord{"18512365786", 0, 1477050308, 100}} // 设置 records 数组
	rd := SPRIReqData{"18687082306", "866657020185815", records, contacts}

	//set your own accessKey
	smtr := ShumeiPRIRequest{"xxxxxxxxx", rd}
	bys, _ := json.Marshal(&smtr)
	header := map[string]string{"Content-Type": "application/json", "Content-Length": strconv.Itoa(len(string(bys)))}

	response, err := hc.SendPostRequest(url, header, string(bys))
	if err != nil {
		fmt.Println(fmt.Sprintf("Error: %v\n", err))
		return
	}
	fmt.Println(response)

	resJson := ShumeiFMResult{}
	err = json.Unmarshal([]byte(response), &resJson)
	if err != nil {
		fmt.Println(fmt.Sprintf("Error: %v\n", err))
		return
	}

	/**
	 * 接口会返回code， code=1100 时说明请求成功
	 * 当 code!=1100 时，如果是 1902 错误，需要检查参数配置
	 * 其余情况需要根据错误码进行重试或者其它异常处理
	 */
	if resJson.Code == 1100 {
		// 正常业务处理
	} else {
		// 接口请求失败，需要参照返回码进行不同的处理
	}
}
