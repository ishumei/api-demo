import net.sf.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/10/20.
 */

public class PhoneLabel {
    public static void main(String[] args) {
        HashMap<String, Object> userData = new HashMap<String, Object>();
        //please set your own accessKey
        userData.put("accessKey", "XXXXXXXXXXXXXXXXXXX");
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("phone", "18687082306");
        userData.put("data", data);
        JSONObject json = JSONObject.fromObject(userData);
        JSONObject result = HttpRequestUtils.httpPost("http://finance-api.fengkongcloud.com/v2/finance/labels", json);
        System.out.println(result.toString());
    }
}
