package com.anztim.library.manager.utils;

/**
 * @author anztim
 */
public class JSONUtil {
    public static Integer valueOfMoney(String str) {
        if (!str.matches("\\d+([.]\\d+)?")) return null;
        String[] split = str.split("\\.");
        if (split.length == 1) return Integer.parseInt(split[0]);
        else {
            int yuan = Integer.parseInt(split[0]);
            int fen = Integer.parseInt(split[1]);
            return yuan * 100 + fen;
        }
    }

    public static String stringOfMoney(int value) {
        return String.valueOf(value / 100) + '.' + value % 100;
    }
}
