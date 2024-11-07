package org.example;

import java.util.regex.Pattern;

public class Password {
    public static String lowercase = "([a-z])";
    public static String uppercase = "([A-Z])";
    public static String number = "([0-9])";
    public static String special = "([!@#$%^&*()])";
    public static String length = "(.{9,})";

    public static boolean validate( String password) {
        Pattern character = Pattern.compile(lowercase);
        Pattern upper = Pattern.compile(uppercase);
        Pattern digit = Pattern.compile(number);
        Pattern character_special = Pattern.compile(special);
        Pattern length_characters = Pattern.compile(length);
        return character.matcher(password).find() &&
                upper.matcher(password).find() &&
                digit.matcher(password).find() &&
                length_characters.matcher(password).find() &&
                character_special.matcher(password).find();
    }
}
class PasswordValidatorDemo {
    public static void main(String[] args) {
        System.out.println(Password.validate("a%20A48"));
        System.out.println(Password.validate("a%2048rdA"));
        System.out.println(Password.validate("789456123565aA@"));
    }
}



