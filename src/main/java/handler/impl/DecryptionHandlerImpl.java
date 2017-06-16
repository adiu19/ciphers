package handler.impl;

import enums.Technique;
import handler.DecryptionHandler;

/**
 * Created by Aditya Upadhyaya on 16/06/17.
 */
public class DecryptionHandlerImpl implements DecryptionHandler {

    public String decrypt(String ciphertext, int shiftValue, String keyword,Technique technique) {
        String plaintext;

        if (ciphertext == null)
            return null;

        StringBuilder sb = new StringBuilder();
        switch (technique){
            case CAESAR_SHIFT:          //monoalphabetic
                for(int index = 0; index < ciphertext.length(); index++) {
                    if(Character.isUpperCase(ciphertext.charAt(index)))
                        sb.append(Character.toString((char) (( ((((int) ciphertext.charAt(index) - 65 ) - shiftValue) % 26 + 26 ) % 26 ) + 65 )));
                    else if(Character.isLowerCase(ciphertext.charAt(index)))
                        sb.append(Character.toString((char) (( ((((int) ciphertext.charAt(index) - 97 ) - shiftValue) % 26 + 26 ) % 26 ) + 97 )));
                    else
                        sb.append(Character.toString(ciphertext.charAt(index)));
                }
                break;
            case ATBASH:               //monoalphabetic
                for(int index = 0; index < ciphertext.length(); index++){
                    if(Character.isUpperCase(ciphertext.charAt(index)))
                        sb.append(Character.toString((char)((- ((int)ciphertext.charAt(index) - 65 + 1 ) % 26 + 26 ) % 26 + 65 )));
                    else if(Character.isLowerCase(ciphertext.charAt(index)))
                        sb.append(Character.toString((char)((- ((int)ciphertext.charAt(index) - 97 + 1 ) % 26 + 26 ) % 26 + 97 )));
                    else
                        sb.append(Character.toString(ciphertext.charAt(index)));
                }
                break;
            case KEYWORD:
                if(keyword == null)
                    return null;
                //TODO
                break;
            case VIGENERE:          //polyalphabetic
                if(keyword == null)
                    return null;

                for(int index = 0; index < ciphertext.length(); index++) {
                    if(Character.isUpperCase(ciphertext.charAt(index)))
                        sb.append( Character.toString((char)((((int)ciphertext.charAt(index) - 65 ) - ((int)Character.toUpperCase(keyword.charAt(index % keyword.length())) - 65 ) % 26  + 26 ) % 26 + 65 )));
                    else if (Character.isLowerCase(ciphertext.charAt(index)))
                        sb.append( Character.toString((char)((((int)ciphertext.charAt(index) - 65) - ((int)Character.toLowerCase(keyword.charAt(index % keyword.length())) - 65 ) % 26 + 26) % 26 + 97 )));
                    else
                        sb.append(Character.toString(ciphertext.charAt(index)));
                }
            default:
                break;
        }
        plaintext = sb.toString();


        return plaintext;
    }
}
