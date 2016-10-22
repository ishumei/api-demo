import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/20.
 */

public class PhoneRiskIndex {
    public static void main(String[] args) {
        HashMap<String, Object> userData = new HashMap<String, Object>();
        //please set your own accessKey
        userData.put("accessKey", "xxxxxxxxxxxxxxxxxxxx");
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("phone", "18687082306");
        data.put("imei","866657020185815");
        HashMap<String, Object> rd = new HashMap<String, Object>();
        rd.put("phone", "18567876547");
        rd.put("type", 0);
        rd.put("startTime", 18776);
        rd.put("duration", 100);
        HashMap<String, Object> ct = new HashMap<String, Object>();
        ct.put("phone","18765678743");
        ct.put("name","dazhi");
        List<HashMap<String, Object>> rs = new ArrayList<HashMap<String, Object>>();
        rs.add(rd);
        List<HashMap<String, Object>> cs = new ArrayList<HashMap<String, Object>>();
        cs.add(ct);
        data.put("records", rs);
        data.put("contacts", cs);
        userData.put("data", data);
        JSONObject json = JSONObject.fromObject(userData);
        JSONObject result = HttpRequestUtils.httpPost("http://finance-api.fengkongcloud.com/v2/finance/malagent", json);
        System.out.println(result.toString());
    }
}

