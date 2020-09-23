import net.sf.json.JSONObject;

import java.util.HashMap;

public class Text {
    private static final String URL = "http://api-text-bj.fengkongcloud.com/v2/saas/anti_fraud/text";
    private static final String ACCESS_KEY = "{ACCESS_KEY}";

    public static void main(String[] args) {
        HashMap<String, Object> payload = new HashMap<String, Object>();
        payload.put("accessKey", ACCESS_KEY);
        payload.put("type", "SOCIAL");
        payload.put("appId", "default");

        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("text", "{TEXT}");
        data.put("tokenId", "{UID}");

        payload.put("data", data);

        JSONObject json = JSONObject.fromObject(payload);
        JSONObject result = Utils.httpPost(URL, json);

        json = JSONObject.fromObject(result);
		// 通过 code 和 riskLevel 判断返回，具体请参考接口文档
        System.out.println(json.toString());
    }
}