package com.company;

import com.company.validators.PasswordChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCheckerTest {

    PasswordChecker passwordChecker = new PasswordChecker();

    @Test
    void TestPasswordIsCorrect(){
        assertTrue(passwordChecker.checkPassword("PasswordPassword5+", "+-*.><?/", 8));
    }

    @Test
    void TestPasswordIsNotEmpty(){
        assertFalse(passwordChecker.checkPassword(""));
    }

    @Test
    void TestPasswordIsNotNull(){
        assertFalse(passwordChecker.checkPassword(null));
    }

    @Test
    void TestPasswordIsNotLongEnough(){
        assertFalse(passwordChecker.checkPassword("Passwo+", 8));
    }

    @Test
    void TestPasswordDoesNotHaveUppercase(){
        assertFalse(passwordChecker.checkPassword("password+"));
    }

    @Test
    void TestPasswordHasSpecialCharacter(){
        assertTrue(passwordChecker.checkPassword("Password&", "&+-*.><?/"));
    }
}