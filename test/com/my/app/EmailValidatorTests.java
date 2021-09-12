package com.my.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailValidatorTests {

    EmailValidator emailValidator;

    @BeforeEach
    void setUp()
    {
        emailValidator = new EmailValidator();
    }

    @Test
    void validateEmail_EmailIsValid_ExpectedResultTrue()
    {
        assertTrue(emailValidator.validateEmail("qwerty@gmail.com"));
    }

    @Test
    void validateEmail_EmailDoesNotContainEtaSymbol_ExpectedResultFalse()
    {
        assertFalse(emailValidator.validateEmail("qwertygmail.com"));
    }

    @Test
    void validateEmail_EmailContainsIllegalSymbols_ExpectedResultFalse()
    {
        assertFalse(emailValidator.validateEmail("qw©rty@gmail.com"));
    }

    @Test
    void validateEmail_EmailContainsWrongDomain_ExpectedResultFalse()
    {
        assertFalse(emailValidator.validateEmail("qwerty@ail.com"));
    }

    @Test
    void validateEmail_EmailContainsWrongTopLevelDomain_ExpectedResultFalse()
    {
        assertFalse(emailValidator.validateEmail("qwerty@gmail.c"));
    }

}
