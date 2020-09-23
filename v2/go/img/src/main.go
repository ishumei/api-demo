/**
 * 运行本demo，运行 sh run.sh 即可
**/

package main

import (
	"encoding/base64"
	"encoding/json"
	"fmt"
	"io/ioutil"
	"lib"
	"log"
	"os"
	"path/filepath"
	"strconv"
	"strings"
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

func getCurrentDir() string {
	dir, err := filepath.Abs(filepath.Dir(os.Args[0]))
	if err != nil {
		log.Fatal(err)
	}
	return strings.Replace(dir, "\\", "/", -1)
}

func main() {
	hc := httpclient.NewHttpClient(10e9, 10e9)
	url := "http://api.fengkongcloud.com/v2/saas/anti_fraud/img"
	dir := getCurrentDir()
	imageContent, err := ioutil.ReadFile(dir + "/../src/demo.jpg")
	if err != nil {
		fmt.Println(fmt.Sprintf("Error: %v", err))
		return
	}

	// 获取图片 base64 编码
	imgStr := base64.StdEncoding.EncodeToString(imageContent)
	//set your own accessKey
	smtr := ShumeiImgRequest{"xxxxxx", "AD", map[string]interface{}{"tokenId": "tokenId_test", "img": imgStr}}
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
