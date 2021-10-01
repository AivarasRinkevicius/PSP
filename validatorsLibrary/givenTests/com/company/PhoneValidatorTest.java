package com.company;

import com.company.validators.PhoneValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneValidatorTest {

    PhoneValidator phoneValidator = new PhoneValidator();

    @Test
    void TestNumberIsCorrect(){
        assertTrue(phoneValidator.validatePhone("+37069070000"));
    }

    @Test
    void TestNumberIsNotEmpty(){
        assertFalse(phoneValidator.validatePhone(""));
    }

    @Test
    void TestNumberIsNotNull(){
        assertFalse(phoneValidator.validatePhone(null));
    }

    @Test
    void TestNumberHasNoSymbols(){
        assertFalse(phoneValidator.validatePhone("8612x4567"));
    }

    @Test
    void TestNumberStartsWith8(){
        assertTrue(phoneValidator.validatePhone("862518456"));
    }

    @Test
    void TestNumberCorrectlyAddsCountryCode(){
        assertTrue(phoneValidator.validatePhone("+15626624600", "+1", 12));
    }

}