package com.subhadipmitra.code.consentbase;

import java.util.Arrays;
import java.util.List;

public class Seed {

    public static final List<String> customerType = Arrays.asList("ANON", "NTB", "ETB", "BOT");
    public static final List<String> channel = Arrays.asList("WEBSITE MAIN", "SMS", "MOBILE APP", "SOCIAL",
            "VOICE CALL", "CUST CENTER");
    public static final List<String> scope = Arrays.asList("Analytics", "A/B Testing and Personalization",
            "Conversion Tracking", "Marketing Automation", "Re-marketing", "User Feedback");

    public static final String id_prefix = "CUST_";
    public static final String nist_prefix = "NIST_";
}
