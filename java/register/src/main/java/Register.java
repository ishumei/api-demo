import net.sf.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/10/20.
 */

public class Register {
    public static void main(String[] args) {
        HashMap<String, Object> userData = new HashMap<String, Object>();
        //please set your own accessKey
        userData.put("accessKey", "XXXXXXXXXXXXXXXXXXXXX");
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("tokenId", "tokenId_test");
        data.put("registerTime", 1477034215);
        data.put("ip", "127.0.0.1");
        userData.put("data", data);
        JSONObject json = JSONObject.fromObject(userData);
        JSONObject result = HttpRequestUtils.httpPost("http://api.fengkongcloud.com/v2/saas/register", json);
        System.out.println(result.toString());
        json = JSONObject.fromObject(result);
        if ((int)json.get("code") == 1100) {
            String riskLevel = (String) json.get("riskLevel");
            if (riskLevel == "PASS") {
			    // 放行
            } else if (riskLevel == "REVIEW") {
			    // 人工审核，如果没有审核，就放行
            } else if (riskLevel == "REJECT") {
			    // 拒绝
            } else {
			    // 异常
            }
        }
    }
}
