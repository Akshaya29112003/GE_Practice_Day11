import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class User_RegistrationTestTest {

    @Test
    public void firstName_Happy() {
        assertTrue(User_Registration_junit.first_name("John"), "Expected valid first name");
    }

    @Test
    public void firstName_Sad() {
        assertFalse(User_Registration_junit.first_name("jo"), "Expected invalid first name");
        assertFalse(User_Registration_junit.first_name("john"), "Expected invalid first name");
    }

    @Test
    public void lastName_Happy() {
        assertTrue(User_Registration_junit.last_name("Doe"), "Expected valid last name");
    }

    @Test
    public void lastName_Sad() {
        assertFalse(User_Registration_junit.last_name("do"), "Expected invalid last name");
        assertFalse(User_Registration_junit.last_name("doe"), "Expected invalid last name");
    }

    @Test
    public void email_Happy() {
        assertTrue(User_Registration_junit.Email("john.doe@example.com"), "Expected valid email");
    }

    @Test
    public void email_Sad() {
        assertFalse(User_Registration_junit.Email("john.doe@.com"), "Expected invalid email");
        assertFalse(User_Registration_junit.Email("john@com"), "Expected invalid email");
    }

    @Test
    public void phone_Happy() {
        assertTrue(User_Registration_junit.Phone("91 1234567890"), "Expected valid phone number");
    }

    @Test
    public void phone_Sad() {
        assertFalse(User_Registration_junit.Phone("911234567890"), "Expected invalid phone number");
        assertFalse(User_Registration_junit.Phone("91 12345"), "Expected invalid phone number");
    }

    @Test
    public void password_Happy() {
        assertTrue(User_Registration_junit.Password("Abc@1234"), "Expected valid password");
    }

    @Test
    public void password_Sad() {
        assertFalse(User_Registration_junit.Password("abc1234"), "Expected invalid password (no uppercase or special character)");
        assertFalse(User_Registration_junit.Password("Abc12345"), "Expected invalid password (no special character)");
        assertFalse(User_Registration_junit.Password("Abc@12"), "Expected invalid password (less than 8 characters)");
        assertFalse(User_Registration_junit.Password("Abc@@1234"), "Expected invalid password (more than 1 special character)");
    }


    @ParameterizedTest
    @CsvSource({
            "john.doe@example.com, true",    // Valid email
            "abc.xyz@bl.co.in, true",        // Valid email
            "john.doe@.com, false",          // Invalid email (missing domain name)
            "john@com, false",               // Invalid email (missing top-level domain)
            "john@domain, false",            // Invalid email (missing .something)
            "@example.com, false",           // Invalid email (missing local part)
            "john.doe@domain.co.in, true"    // Valid email
    })
    void validateEmails(String email, boolean expectedResult) {
        boolean actualResult = User_Registration_junit.Email(email);
        assertEquals("Failed for email: " + email, expectedResult, actualResult);
    }
}