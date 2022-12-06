package Controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncription {

    public static String encrypt(char[] password){
        try {
            String pass = "";
            for (char letter : password)
                pass+=letter;

            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(pass.getBytes());

            byte[] bytes = m.digest();

            StringBuilder s = new StringBuilder();
            for (int i = 0; i < bytes.length; i++){
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            System.out.println("User password: "+pass);
            System.out.println("Encrypted password: " + s.toString());

            return s.toString();
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        return "";
    }
    public static boolean validatePassword(String encryptPass, char[] pass){
        System.out.println("Try validate");
        return MD5(pass).equals(encryptPass);
    }

    public static String MD5(char[] password){
        try {
            String pass = "";
            for (char letter : password)
                pass+=letter;
            MessageDigest m = MessageDigest.getInstance("MD5");

            m.update(pass.getBytes());
            byte[] bytes = m.digest();

            StringBuilder s = new StringBuilder();
            for (int i = 0; i < bytes.length; i++){
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            return s.toString();
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        return "";
    }

}
