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
    public static void main(String[] args) throws IOException {
        HashMap<String, Object> userData = new HashMap<String, Object>();
        userData.put("accessKey", "XXXXXXXXXXXXXXX");
        userData.put("type","AD");
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("tokenId", "tokenId_test");
        byte[] content = getImg("./demo.jpg");
        String imgStr = new String(Base64.encodeBase64(content), "ISO-8859-1");
        data.put("img", imgStr);
        userData.put("data", data);
        JSONObject json = JSONObject.fromObject(userData);
        JSONObject result = HttpRequestUtils.httpPost("http://api.fengkongcloud.com/v2/saas/anti_fraud/img", json);
        System.out.println(result.toString());
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
