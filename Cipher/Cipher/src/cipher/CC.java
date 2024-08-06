
package cipher;
import java.time.LocalDate;

/**
 *
 * @author C.V
 */
public class CC {
    private static int shift;
    public CC(){
        this.shift = shiftfromdate();
    }
    public static int shiftfromdate() {
        LocalDate currentDate = LocalDate.now();
        int dayOfMonth = currentDate.getDayOfMonth();
        return dayOfMonth;
    }
    public static String cce(String message) {
        StringBuilder enM = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                char encryptedChar = (char) ((character - base + shift) % 26 + base);
                enM.append(encryptedChar);
            } else {
                enM.append(character);
            }
        }
        return enM.toString();
    }

    public static String ccd(String message) {
        StringBuilder dem = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                char decryptedChar = (char) ((character - base - shift + 26) % 26 + base);
                dem.append(decryptedChar);
            } else {
                dem.append(character);
            }
        }
        return dem.toString();
    }
    
}
