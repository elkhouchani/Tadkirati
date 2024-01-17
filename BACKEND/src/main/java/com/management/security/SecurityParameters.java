package com.management.security;

public class SecurityParameters {
    public static final  long EXPIRATION_TIME = System.currentTimeMillis() + 3 * 24 * 60 * 60 * 1000;;
    public static final String SECRET = "secret!2024&";
    public static final String PREFIX = "Bearer";
}
