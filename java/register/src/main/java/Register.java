import net.sf.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/10/20.
 */

public class Register {
    public static void main(String[] args) {
        HashMap<String, Object> userData = new HashMap<String, Object>();
        //please set your own accessKey
        userData.put("accessKey", "4Ky6AV4hE0pWLeG1bXNw");
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("tokenId", "tokenId_test");
        data.put("registerTime", 1477034215);
        data.put("ip", "127.0.0.1");
        userData.put("data", data);
        JSONObject json = JSONObject.fromObject(userData);
        JSONObject result = HttpRequestUtils.httpPost("http://api.fengkongcloud.com/v2/saas/register", json);
        System.out.println(result.toString());
    }
}
