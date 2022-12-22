package com.example.saneforceapplication.api;

public class Request {
    private static final String SF = "MR4383";
    private static final String APPUserSF = "MR4383";
    private static final String div = "35";

    public static String createAuthJsonString() {
        String info = "{\"SF\":\"" + SF + "\",\"APPUserSF\":\"" + APPUserSF + "\",\"div\":\"" + div + "\"}";
        return info;
    }


}
