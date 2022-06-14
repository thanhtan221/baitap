package com.cg.Utils;

import java.util.regex.Pattern;

public class Validate {

    public static final String PHONE_REGEX = "^[0][1-9][0-9]$";



    public static boolean isPriceValid(String number) {
        return Pattern.compile(PHONE_REGEX).matcher(number).matches();
    }
}
