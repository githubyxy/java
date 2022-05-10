package testMethod.Test;

import org.apache.commons.lang3.StringUtils;
import sun.security.provider.MD5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;

/**
 * @author yuxiaoyu
 * @date 2022/5/8 下午3:14
 * @Description
 */
public class SignTest {
    public static void main(String[] args) {
        String Authorization;
        long l = System.currentTimeMillis();
        String timestamp = String.valueOf(l/1000);
        String signature =  md5( timestamp + "7e48b44b853bdd25").toUpperCase();

        Authorization = "EOPAUTH" +" platformid=\"zgydtx2mkbut3wml\",timestamp=\"" + timestamp +"\",signature=\"" +  signature + "\"";
        System.out.println(Authorization);
    }

    public static String md5(String src) {
        if(StringUtils.isNotBlank(src)) {
            try {
                MessageDigest m = MessageDigest.getInstance("MD5");
                m.reset();
                m.update(src.getBytes("utf-8"));
                byte[] digest = m.digest();
                BigInteger bigInt = new BigInteger(1, digest);

                String hashtext;
                for(hashtext = bigInt.toString(16); hashtext.length() < 32; hashtext = "0" + hashtext) {
                    ;
                }

                return hashtext;
            } catch (Exception var5) {
                ;
            }
        }

        return null;
    }
}
