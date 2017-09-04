import net.sf.json.JSONObject;
import org.apache.commons.codec.binary.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/10/20.
 */

public class Img {
    private static final String ACCESSKEY="xxxxxxx"; // 商户的 accessKey
    private static final String REQUEST_URL = "http://api.fengkongcloud.com/v2/saas/anti_fraud/img";

    public static void main(String[] args) throws IOException {
        HashMap<String, Object> userData = new HashMap<String, Object>();
        userData.put("accessKey", ACCESSKEY);
        userData.put("type","AD");

        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("tokenId", "tokenId_test");

        byte[] content = getImg(Img.class.getClassLoader().getResource("demo.jpg").getPath());
        String imgStr = new String(Base64.encodeBase64(content), "ISO-8859-1");
        data.put("img", imgStr);

        userData.put("data", data);

        JSONObject json = JSONObject.fromObject(userData);
        JSONObject result = HttpRequestUtils.httpPost(REQUEST_URL, json);

        System.out.println(result.toString());
        json = JSONObject.fromObject(result);

        /**
         * 接口会返回code， code=1100 时说明请求成功，根据不同的 riskLevel 风险级别进行业务处理
         * 当 code!=1100 时，如果是 1902 错误，需要检查参数配置
         * 其余情况需要根据错误码进行重试或者其它异常处理
         **/
        if (json.getInt("code") == 1100) {
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

    public static byte[] getImg(String filePath) throws IOException{
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[(int)file.length()];
        fis.read(buf);
        fis.close();
        return buf;
    }
}
