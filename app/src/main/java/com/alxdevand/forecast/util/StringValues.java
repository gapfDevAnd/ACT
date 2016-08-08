package com.alxdevand.forecast.util;


public class StringValues {

    private static final String BASE_URL_LOGO = "http://l.yimg.com/a/i/us/we/52/";

    public static StringValues getInstance() {
        return new StringValues();
    }


    public String getImgUrl(String imgCode){
       return String.format("%s%s%s", BASE_URL_LOGO, imgCode, ".gif");
    }
}
