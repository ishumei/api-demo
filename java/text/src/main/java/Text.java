import net.sf.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/10/20.
 */

public class Text {

    private static final String ACCESSKEY="xxxxxxx"; // 商户的 accessKey
    private static final String REQUEST_URL = "http://api.fengkongcloud.com/v2/saas/anti_fraud/text";

    public static void main(String[] args) {
        HashMap<String, Object> userData = new HashMap<String, Object>();
        //please set your own accessKey
        userData.put("accessKey", ACCESSKEY);
        userData.put("type","ZHIBO");

        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("tokenId", "tokenId_test");
        data.put("text", "iphone 7");

        userData.put("data", data);

        JSONObject json = JSONObject.fromObject(userData);
        JSONObject result = HttpRequestUtils.httpPost(REQUEST_URL, json);

        System.out.println(result.toString());
        json = JSONObject.fromObject(result);

        /**
         * 接口会返回code， code=1100 时说明请求成功，根据不同的 riskLevel 风险级别进行业务处理
         * 当 code!=1100 时，如果是 1902 错误，需要检查参数配置
         * 其余情况需要根据错误码进行重试或者其它异常处理
         */
        if (json.getInt("code")== 1100) {
            String riskLevel = json.getString("riskLevel");
            if (riskLevel == "PASS") {
			    // 放行
            } else if (riskLevel == "REVIEW") {
			    // 人工审核，如果没有审核，就放行
            } else if (riskLevel == "REJECT") {
			    // 拒绝
            } else {
			    // 异常
            }
        } else {
            // 接口请求失败，需要参照返回码进行不同的处理
        }
    }
}
