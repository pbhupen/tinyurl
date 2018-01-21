package com.practice.tinyurl.util;

import java.util.Random;

public class TinyUrlServiceUtils {

    public final static String APP_URL = "/turl";
    public final static String SHORTEN_URL_REQUEST = "/shorten";
    public final static String ORIGINAL_URL_REQUEST = "/original";
    // TODO how to make it configurable
    public final static String SHORT_URL_PREFIX = "turl/";

    public static String convertNumberToBase62(long number)
    {
        return null;
    }

    public static int generateRandomNumberOfLength(int length)
    {   Random random = new Random();
        int  base = (int) Math.pow(10, length);
        return random.nextInt(base * 9) + base;
    }
}
