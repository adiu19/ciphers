import enums.Technique;
import handler.DecryptionHandler;
import handler.EncryptionHandler;
import handler.impl.DecryptionHandlerImpl;
import handler.impl.EncryptionHandlerImpl;

/**
 * Created by Aditya Upadhyaya on 16/06/17.
 */
public class Runner {

    public static void main(String[] args) {
        EncryptionHandler encryptionHandler = new EncryptionHandlerImpl();
        DecryptionHandler decryptionHandler = new DecryptionHandlerImpl();
        String input = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
        int shiftValue = 1;
        String encrypted = encryptionHandler.encrypt(input,shiftValue ,"LEMON", Technique.VIGENERE);
        String decrypted = decryptionHandler.decrypt(encrypted, shiftValue, "LEMON", Technique.VIGENERE);
        System.out.println(encrypted);
        System.out.println(decrypted);
        System.out.println(input.equals(decrypted));
    }
}
