import net.sf.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/10/20.
 */

public class Text {
    public static void main(String[] args) {
        HashMap<String, Object> userData = new HashMap<String, Object>();
        //please set your own accessKey
        userData.put("accessKey", "xxxxxxxxxxxxxxxxxxxx");
        userData.put("type","ZHIBO");
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("tokenId", "tokenId_test");
        data.put("text", "iphone 7");
        userData.put("data", data);
        JSONObject json = JSONObject.fromObject(userData);
        JSONObject result = HttpRequestUtils.httpPost("http://api.fengkongcloud.com/v2/saas/anti_fraud/text", json);
        System.out.println(result.toString());
    }
}
