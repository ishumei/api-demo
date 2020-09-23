import net.sf.json.JSONObject;

import java.util.HashMap;

public class Video {
    private static final String URL = "http://api-video-bj.fengkongcloud.com/v2/saas/anti_fraud/video";
    private static final String ACCESS_KEY = "{ACCESS_KEY";

    public static void main(String[] args) {
        HashMap<String, Object> payload = new HashMap<String, Object>();
        payload.put("accessKey", ACCESS_KEY);
        payload.put("imgType", "POLITICS_PORN_AD");
        payload.put("audioType", "NONE");
        payload.put("appId", "default");
        payload.put("btId", "{BT_ID}12");
        payload.put("callback", "https://jsonplaceholder.typicode.com/posts/");

        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("url", "https://jsonplaceholder.typicode.com/posts/");

        payload.put("data", data);

        JSONObject json = JSONObject.fromObject(payload);
        JSONObject result = Utils.httpPost(URL, json);

        json = JSONObject.fromObject(result);
		// 通过 code 和 riskLevel 判断返回，具体请参考接口文档
        System.out.println(json.toString());
    }
}