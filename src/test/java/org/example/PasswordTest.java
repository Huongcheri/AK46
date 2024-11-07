package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PasswordTest {
    @Test
    void verify_ValidPassword() {
        Assert.assertTrue(Password.validate("Admin123%"));
    }

    @Test
    void verify_not_lowercase() {
        Assert.assertFalse(Password.validate("AAAA123%"));
    }

    @Test
    void verify_not_uppercase() {
        Assert.assertFalse(Password.validate("admin123%"));
    }

    @Test
    void verify_not_number() {
        Assert.assertFalse(Password.validate("theriver%"));
    }

    @Test
    void verify_not_character_special() {
        Assert.assertFalse(Password.validate("Atheriver"));
    }

    @Test
    void verify_length_less_than_8() {
        Assert.assertFalse(Password.validate("A78th$"));
    }
}
