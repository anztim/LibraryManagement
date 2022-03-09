package com.anztim.library.manager.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author anztim
 */
public class DateUtil {
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static Date toDate(String str) throws ParseException {
        return FORMAT.parse(str);
    }

    public static String toString(Date date) {
        return FORMAT.format(date);
    }
}
