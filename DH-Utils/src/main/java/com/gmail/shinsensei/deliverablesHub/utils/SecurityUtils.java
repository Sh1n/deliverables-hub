package com.gmail.shinsensei.deliverablesHub.utils;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
/**
 *
 * @author Francesco Bux
 */
public class SecurityUtils {
 
    public static String generateRandomString(int length){
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(length);
    }
    
    public static String hashPassword(String password) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
