package handler;

import enums.Technique;

/**
 * Created by Aditya Upadhyaya on 16/06/17.
 */
public interface EncryptionHandler {

    String encrypt(String plaintext, int shiftValue, String keyword, Technique technique);
}
