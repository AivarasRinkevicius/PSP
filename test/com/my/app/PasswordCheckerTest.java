package com.my.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordCheckerTest {

    PasswordChecker passwordChecker;

    @BeforeEach
    void setUp()
    {
        passwordChecker = new PasswordChecker(10);
        passwordChecker.setCustomCharacters("?+*");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Qwertyuio?","qweAtyBio+", "qwerTyuio*"})
    void TestValidatePassword_PasswordIsValid_ExpectedResultTrue(String password)
    {
        assertTrue(passwordChecker.validatePassword(password));
    }

    @Test
    void TestValidatePassword_PasswordIsTooShort_ExpectedResultFalse()
    {
        assertFalse(passwordChecker.validatePassword("Qwertyu?"));
    }

    @Test
    void TestValidatePassword_PasswordDoesNotContainUppercaseSymbol_ExpectedResultFalse()
    {
        assertFalse(passwordChecker.validatePassword("qwertyuio?"));
    }

    @Test
    void TestValidatePassword_PasswordDoesNotContainSpecialSymbol_ExpectedResultFalse()
    {
        assertFalse(passwordChecker.validatePassword("Qwertyuiout"));
    }

    @Test
    void TestValidatePassword_PasswordIsNull_ExpectedResultFalse()
    {
        assertFalse(passwordChecker.validatePassword(null));
    }

}
