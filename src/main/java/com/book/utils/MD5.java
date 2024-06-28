package com.book.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MD5 {
    public MD5() {
    }

    public static String valueOf(String str) {
        String s = str;
        if (str == null) {
            return "";
        } else {
            String value = null;
            MessageDigest md5 = null;

            try {
                md5 = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException var7) {
            }

            Base64.Encoder encoder = Base64.getEncoder();

            try {
                value = encoder.encodeToString(md5.digest(s.getBytes("utf-8")));
            } catch (Exception var6) {
            }

            return value;
        }
    }

    public static void main(String[] args) {
        System.out.println(valueOf("abc123"));
    }
}
