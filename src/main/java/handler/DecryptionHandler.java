package handler;

import enums.Technique;

/**
 * Created by Aditya Upadhyaya on 16/06/17.
 */
public interface DecryptionHandler {

    String decrypt(String ciphertext, int shiftValue, String keyword, Technique technique);
}
