package com.practice.tinyurl.util;

public class Base62Encoder {

    private static final char[] BASE62_ALPHABET = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static String generateHashForNumber(int number)
    {
        StringBuilder hash = new StringBuilder();
        int remainder = 0;
        int dividend = number;
        while(dividend != 0)
        {
            remainder = dividend % 62;
            hash.append(BASE62_ALPHABET[remainder]);
            dividend = dividend / 62;
        }
        return hash.reverse().toString();
    }
}
