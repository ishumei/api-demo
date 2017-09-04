import net.sf.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/10/20.
 */

public class PhoneLabel {
    private static final String ACCESSKEY="xxxxxx"; // 商户的 accessKey
    private static final String REQUEST_URL = "http://finance-api.fengkongcloud.com/v2/finance/labels";

    public static void main(String[] args) {
        HashMap<String, Object> userData = new HashMap<String, Object>();
        //please set your own accessKey
        userData.put("accessKey", ACCESSKEY);
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("phone", "18687082306");

        userData.put("data", data);

        JSONObject json = JSONObject.fromObject(userData);
        JSONObject result = HttpRequestUtils.httpPost(REQUEST_URL, json);

        System.out.println(result.toString());

        json = JSONObject.fromObject(result);

        /**
         * 接口会返回code， code=1100 时说明请求成功
         * 当 code!=1100 时，如果是 1902 错误，需要检查参数配置
         * 其余情况需要根据错误码进行重试或者其它异常处理
         */
        if (json.getInt("code")== 1100) {
            // 正常业务处理
        } else {
            // 接口请求失败，需要参照返回码进行不同的处理
        }

    }
}
