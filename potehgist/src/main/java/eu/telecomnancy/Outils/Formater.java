package eu.telecomnancy.Outils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Formater {
    public static final String USERNAME_REGEX = "^[a-zA-Z0-9_-]{4,32}$";
    public static final int MIN_PASSWORD_LENGTH = 8;
    public static final int MAX_DESCRIPTION_LENGTH = 1803;

    public static boolean checkUsername(String username) {
        return username.matches(USERNAME_REGEX);
    }

    public static boolean checkPassword(String password) {
        return password.length() >= MIN_PASSWORD_LENGTH;
    }

    public static String format(String s) {
        return s.replaceAll("'", "''");
    }

    public static boolean checkCodePostal(String codePostal) {
        return codePostal.matches("^[0-9AB]{5}$");
    }

    public static boolean checkMail(String mail) {
        return mail.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]{2,}\\.[a-z]{2,4}$");
    }

    public static String addNewlines(String s, int n) {
        if (s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        int index = 0;
        int lastspace = -1;
        for (char c : sb.toString().toCharArray()) {
            if (c == '\n') {
                i = 0;
            }
            if (c == ' ') {
                lastspace = index;
            }
            if (++i % n == 0) {
                if (lastspace != -1) {
                    sb.setCharAt(lastspace, '\n');
                    lastspace = -1;
                } else {
                    sb.insert(index, '\n');
                }
            }
            index++;
        }
        return sb.toString();
    }

    public static boolean checkDescription(String description) {
        return description.length() <= MAX_DESCRIPTION_LENGTH;
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

    public static String shortenPrice(int price) {
        String sortie = String.valueOf(price);
        if (price >= 1000000000) {
            sortie = sortie.substring(0, sortie.length() - 9) + "G";
        } else if (price >= 1000000) {
            sortie = sortie.substring(0, sortie.length() - 6) + "M";
        } else if (price >= 1000) {
            sortie = sortie.substring(0, sortie.length() - 3) + "k";
        }
        return sortie;
    }
}
