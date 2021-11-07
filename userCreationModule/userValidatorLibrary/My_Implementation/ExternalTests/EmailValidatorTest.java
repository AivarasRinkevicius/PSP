package My_Implementation.ExternalTests;

import My_Implementation.Validators.EmailValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailValidatorTest {
    @Test
    void testEmailHasMoreThanOneEtaSymbols(){
        assertFalse(EmailValidator.validateEmail("labas@labas@labas.lt"));
    }
    @Test
    void testEmailUserPartWithCommentsInTheEnd() {
        assertTrue(EmailValidator.validateEmail("labas(komentaras)@labas.lt"));
    }
    @Test
    void testEmailDomainWithCommentsInTheBeginning() {
        assertTrue(EmailValidator.validateEmail("(komentaras)labas@labas.lt"));
    }

    @Test
    void testEmailTopLevelDomain() {
        assertTrue(EmailValidator.validateEmail("labas@labas.com"));
    }
    @Test
    void testEmailTopLevelDomainStartsWithHyphen() {
        assertFalse(EmailValidator.validateEmail("labas@labas.-com"));
    }
    @Test
    void testEmailTopLevelDomainEndsWithHyphen() {
        assertFalse(EmailValidator.validateEmail("labas@labas.com-"));
    }
    @Test
    void testEmailIsNull() {
        assertFalse(EmailValidator.validateEmail(""));
    }
    @Test
    void testEmailUsernamePartIsNull() {
        assertFalse(EmailValidator.validateEmail("@labas.com"));
    }

    @Test
    void testEmailTLDLength() {
        assertFalse(EmailValidator.validateEmail("labas@labas.c"));
    }
}
