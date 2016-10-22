import net.sf.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/10/20.
 */

public class DeviceUpload {
    public static void main(String[] args) {
        HashMap<String, Object> userData = new HashMap<String, Object>();
        //please set your own accessKey
        userData.put("organization", "xxxxxxxxxxxxxxxxxxxx");
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("fingerprint", "866657020185815");
        data.put("sessionId", "0987654321");
        userData.put("data", data);
        JSONObject json = JSONObject.fromObject(userData);
        JSONObject result = HttpRequestUtils.httpPost("http://fp.fengkongcloud.com/v1/profile", json);
        System.out.println(result.toString());
    }
}
