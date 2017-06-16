package handler.impl;

import enums.Technique;
import handler.EncryptionHandler;

/**
 * Created by Aditya Upadhyaya on 16/06/17.
 */
public class EncryptionHandlerImpl implements EncryptionHandler {

    public String encrypt(String plaintext, int shiftValue, String keyword,Technique technique) {
        String ciphertext;
        if (plaintext == null)
            return null;

        StringBuilder sb = new StringBuilder();
        switch (technique){
            case CAESAR_SHIFT:          //monoalphabetic
                for(int index = 0; index < plaintext.length(); index++) {
                    if(Character.isUpperCase(plaintext.charAt(index)))
                        sb.append(Character.toString((char) (((((int) plaintext.charAt(index) - 65 ) + shiftValue) % 26 ) + 65 )));
                    else if(Character.isLowerCase(plaintext.charAt(index)))
                        sb.append(Character.toString((char) (((((int) plaintext.charAt(index) - 97 ) + shiftValue) % 26 ) + 97 )));
                    else
                        sb.append(Character.toString(plaintext.charAt(index)));
                }
                break;
            case ATBASH:               //monoalphabetic
                for(int index = 0; index < plaintext.length(); index++){
                    if(Character.isUpperCase(plaintext.charAt(index)))
                        sb.append(Character.toString((char)((- ((int)plaintext.charAt(index) - 65 + 1) % 26 + 26) % 26 + 65)));
                    else if(Character.isLowerCase(plaintext.charAt(index)))
                        sb.append(Character.toString((char)((- ((int)plaintext.charAt(index) - 97 + 1) % 26 + 26) % 26 + 97)));
                    else
                        sb.append(Character.toString(plaintext.charAt(index)));
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

                for(int index = 0; index < plaintext.length(); index++) {
                    if(Character.isUpperCase(plaintext.charAt(index)))
                        sb.append( Character.toString((char)((((int)plaintext.charAt(index) - 65 ) + ((int)Character.toUpperCase(keyword.charAt(index % keyword.length())) - 65 )) % 26  + 65 )));
                    else if (Character.isLowerCase(plaintext.charAt(index)))
                        sb.append( Character.toString((char)((((int)plaintext.charAt(index) - 97 ) + ((int)Character.toLowerCase(keyword.charAt(index % keyword.length())) - 65 )) % 26 + 97 )));
                    else
                        sb.append(Character.toString(plaintext.charAt(index)));
                }
            default:
                break;
        }
        ciphertext = sb.toString();
        return ciphertext;
    }
}
