package com.my.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordCheckerTests {

    PasswordChecker passwordChecker;

    @BeforeEach
    void setUp()
    {
        passwordChecker = new PasswordChecker();
    }

    @Test
    void validatePassword_PasswordIsValid_ExpectedResultTrue()
    {
        assertTrue(passwordChecker.validatePassword(10, "Qwertyuio?"));
    }

    @Test
    void validatePassword_PasswordIsTooShort_ExpectedResultFalse()
    {
        assertFalse(passwordChecker.validatePassword(10, "Qwertyu?"));
    }

    @Test
    void validatePassword_PasswordDoesNotContainUppercaseSymbol_ExpectedResultFalse()
    {
        assertFalse(passwordChecker.validatePassword(10, "qwertyuio?"));
    }

    @Test
    void validatePassword_PasswordDoesNotContainSpecialSymbol_ExpectedResultFalse()
    {
        assertFalse(passwordChecker.validatePassword(10, "Qwertyuiout"));
    }

}
