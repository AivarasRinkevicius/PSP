package com.company;

import com.company.validators.EmailValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    EmailValidator emailValidator = new EmailValidator();

    @Test
    void TestEmailIsCorrect(){
        assertTrue(emailValidator.validateEmail("Email@google.com"));
    }

    @Test
    void TestEmailIsNotEmpty(){
        assertFalse(emailValidator.validateEmail(""));
    }

    @Test
    void TestEmailIsNotNull(){
        assertFalse(emailValidator.validateEmail(null));
    }

    @Test
    void TestEmailDoesNotHaveEtaSymbol(){ assertFalse(emailValidator.validateEmail("Emailgoogle.com")); }

    @Test
    void TestEmailHasBannedSymbol(){
        assertFalse(emailValidator.validateEmail("©mail@google.com"));
    }

    @Test
    void TestEmailHasIncorrectDomain(){
        assertFalse(emailValidator.validateEmail("Email@googe.com"));
    }

    @Test
    void TestEmailHasIncorrectTLD(){
        assertFalse(emailValidator.validateEmail("Email@google.co"));
    }
}