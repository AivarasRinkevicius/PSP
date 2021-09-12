package com.my.app;

import java.util.HashMap;
import java.util.Map;

public class PhoneValidator {

    private Map<String, String> prefix = new HashMap<>();
    private Map<String, Integer> length = new HashMap<>();

    public PhoneValidator()
    {
        prefix.put("LT","+37063955076");
        length.put("LT",12);
    }

    public void setPrefix(String country, String prefix) {
        this.prefix.put(country,prefix);
    }

    public void setLength(String country, Integer length) {
        this.length.put(country,length);
    }

    private boolean checkIfPhoneContainsOnlyNumbers(String phoneNumber)
    {
        return false;
    }

    private String changePhonePrefix(String phoneNumber, String country)
    {
        return null;
    }

    private boolean checkPhoneLength(String phoneNumber, String country)
    {
        return false;
    }

    public boolean validatePhone(String phoneNumber, String country)
    {
        return false;
    }

}
