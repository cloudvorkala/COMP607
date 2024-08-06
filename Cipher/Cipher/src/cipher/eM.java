
package cipher;
import java.math.BigInteger;
import java.security.SecureRandom;

/**
 *
 * @author C.V
 */
public class eM {
    public static String eM(String message, BigInteger e, BigInteger n) {
        StringBuilder enm = new StringBuilder();
        SecureRandom rand = new SecureRandom();
        
        for (char a : message.toCharArray()) {
            int randomPadding = rand.nextInt(100);
            BigInteger paddedChar = BigInteger.valueOf((int) a).multiply(BigInteger.valueOf(100)).add(BigInteger.valueOf(randomPadding));
            BigInteger enc = paddedChar.modPow(e, n);
            enm.append(enc).append(" ");
        }
        
        return enm.toString().trim();
    }

    public static String dm(String message, BigInteger d, BigInteger n) {
        StringBuilder dem = new StringBuilder();
        String[] enV = message.split(" ");
        
        for (String a : enV) {
            BigInteger c = new BigInteger(a);
            BigInteger paddedChar = c.modPow(d, n);
            int originalCharValue = paddedChar.divide(BigInteger.valueOf(100)).intValue();
            dem.append((char) originalCharValue);
        }
        
        return dem.toString();
    }
}
