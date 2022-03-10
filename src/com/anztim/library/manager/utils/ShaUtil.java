package com.anztim.library.manager.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author anztim
 */
public class ShaUtil {
    public static String sha256(String scr) {
        String result = null;

        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(scr.getBytes());
            byte[] byteBuffer = messageDigest.digest();

            StringBuilder strHexString = new StringBuilder();
            for (byte b : byteBuffer) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    strHexString.append('0');
                }
                strHexString.append(hex);
            }
            result = strHexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
}
