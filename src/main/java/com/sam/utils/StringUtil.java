package com.sam.utils;

public class StringUtil {

    public static String repeat(String str, int num) {
        return repeat(str, num, "");
    }

    public static String repeat(String str, int num, String delimeter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(delimeter).append(str);
        }
        return sb.substring(delimeter.length());
    }
}
