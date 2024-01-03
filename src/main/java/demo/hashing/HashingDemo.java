package org.embibe.demo.hashing;

import java.security.*;

public class HashingDemo {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String message = "Hello, World!!";
        byte[] byteArray = message.getBytes();

        System.out.println("Message => "+message);
        for (byte b : byteArray) {
            System.out.print(b+" ");
        }

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashedValue = digest.digest(byteArray);

        StringBuilder hexString = new StringBuilder();

        for (byte b : hashedValue) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        System.out.println("\nBinary value => "+hexString);

    }

}
