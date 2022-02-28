package com.javatar.blockchain;

import java.security.MessageDigest;

/**
 * Copyright 2021 (C) javatar
 *
 * @author esmaeil sadeghi
 * @email esmailsadeghijob@gmail.com
 * @date 2/28/22
 */
public class Crypt {

    // Function that takes the string input
    // and returns the hashed string.
    public static String sha256(String input) {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            int i = 0;

            byte[] hash = sha.digest(input.getBytes("UTF-8"));

            // hexHash will contain
            // the Hexadecimal hash
            StringBuffer hexHash = new StringBuffer();

            while (i < hash.length) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1)
                    hexHash.append('0');
                hexHash.append(hex);
                i++;
            }

            return hexHash.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
