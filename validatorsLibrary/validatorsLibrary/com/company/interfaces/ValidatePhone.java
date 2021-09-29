package com.company.interfaces;

public interface ValidatePhone {
    boolean validatePhone(String phoneNumber);
    boolean validatePhone(String phoneNumber, String countryCode, int length);
}
