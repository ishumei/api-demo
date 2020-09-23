import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/10/20.
 */

public class DttSms {
    private static final String ACCESSKEY="xxxxxxxx"; // 商户的 accessKey
    private static final String REQUEST_URL = "http://finance-api.fengkongcloud.com//v2/saas/finance/dttsms";
    private static final String SECRETKEY = "xxxxxxxxxx"; // 商户的secretKey

    public static void main(String[] args) {
        HashMap<String, Object> userData = new HashMap<String, Object>();
        //please set your own accessKey
        userData.put("accessKey", ACCESSKEY);
        HashMap<String, Object> data = new HashMap<String, Object>();
        // 设置请求参数
        data.put("deviceId", "20170226082351904fce3bc7d7d3b5ce1d6d3308532999fd6c165881fd69fd");

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

            String encrySms = json.getJSONObject("detail").getString("sms");
            System.out.println(encrySms);

            if (!StringUtils.isEmpty(encrySms)) {
                String key = DigestUtils.md5Hex(SECRETKEY);
                String sms = deCrypt(key, key.substring(0, 16), encrySms);
                System.out.println(sms);
                if (!StringUtils.isEmpty(sms)) {
                    JSONArray jsonData = JSONArray.fromObject(sms);
                    for (Object obj : jsonData) {

                        JSONObject jsonObject = JSONObject.fromObject(obj);

                        String content = jsonObject.getString("content");
                        String tel = jsonObject.getString("tel");
                        System.out.println("content=" + content + ", tel=" + tel);
                    }
                }
            }
        } else {
            // 接口请求失败，需要参照返回码进行不同的处理
        }

    }

    /**
     * java 默认支持最大128位的加密，如果报  Illegal key size 错误，请参考下面：
     * 按照 java 不同版本下载对应的文件
     * java6: http://www.oracle.com/technetwork/java/javase/downloads/jce-6-download-429243.html
     * java7: http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html
     * java8: http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html
     * 需要把 US_export_policy.jar 和 local_policy.jar 两个文件复制到 $JAVA_HOME/jre/lib/security 下面
     * @param key
     * @param initVector
     * @param encrypted
     * @return
     */
    private static String deCrypt(String key, String initVector, String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes());
            SecretKeySpec skSpec = new SecretKeySpec(key.getBytes(), "AES");
            // 可以看到java允许的 key 长度
            // int maxKeyLen = Cipher.getMaxAllowedKeyLength("AES");

            Cipher cipher = Cipher.getInstance("AES/CFB/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, skSpec, iv);
            byte[] original = cipher.doFinal(DatatypeConverter.parseBase64Binary(encrypted));

            return new String(original);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
