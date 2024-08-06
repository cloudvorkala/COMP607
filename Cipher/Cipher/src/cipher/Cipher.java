
package cipher;
import java.math.BigInteger;
import java.security.SecureRandom;


/**
 *
 * @author C.V
 */

public class Cipher {
    
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        
        BigInteger p = BigInteger.probablePrime(8, random), q = BigInteger.probablePrime(8, random), e = BigInteger.valueOf(607);
        endn code = new endn(p,q,e);
        
        String originalMessage = "The highest bidding price is 406714 NZ$";
        System.out.println("Original Message: " + originalMessage);
        System.out.println("p: "+ p +"  q: " + q +"  e: " + e);
        System.out.println("\nPublic Key: ("+code.gete()+","+code.getn()+")  Private Key: ("+code.getd()+","+code.getn()+")\n");
        
        String ccm = CC.cce(originalMessage);
        String encryptedMessage = eM.eM(ccm, code.gete(), code.getn());
        System.out.println("Encrypted Message: " + encryptedMessage);
        
        String decryptedMessage = eM.dm(encryptedMessage, code.getd(), code.getn());
        String cce = CC.ccd(decryptedMessage);
        System.out.println("Decrypted Message: " + cce);
        
        
    }
    
}
