
package cipher;
import java.math.BigInteger;

/**
 *
 * @author C.V
 */
public class endn {
    private BigInteger e,n,d;
    
    public endn(BigInteger p, BigInteger q, BigInteger s){
        this.n =  p.multiply(q);
        
        // φ(n) = (p-1)(q-1) 
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)); 
        this.e = s;
        this.d = e.modInverse(phi);
        
    }
    public BigInteger gete(){
        return this.e;
    }
    public BigInteger getn(){
        return this.n;
    }
    public BigInteger getd(){
        return this.d;
    }
    
    
}
