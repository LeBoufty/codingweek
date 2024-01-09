package eu.telecomnancy;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Formater {
    public static final String USERNAME_REGEX = "^[a-zA-Z0-9_-]{4,32}$";
    public static final int MIN_PASSWORD_LENGTH = 8;

    public static boolean checkUsername(String username) {
        return username.matches(USERNAME_REGEX);
    }

    public static boolean checkPassword(String password) {
        return password.length() >= MIN_PASSWORD_LENGTH;
    }

    public static String format(String s) {
        return s.replaceAll("'", "''");
    }

    public static String hash(String s) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(s.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(encodedhash);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
