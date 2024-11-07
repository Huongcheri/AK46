package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExerciseTest {
        @Test
    void verify_10_is_EvenNumer () {

        Assert.assertTrue (Exercise.isEven(10));
    }
    @Test
    void  verify_3_is_OddNumber() {

        Assert.assertFalse (Exercise.isEven(5));
    }
    @Test
    void  verify_0_is_OddNumber(){

        Assert.assertTrue(Exercise.isEven(0));
    }
    @Test
    void  verify_2024_is_leap_year(){

        Assert.assertTrue(Exercise.isEven(2024));
    }
    @Test
    void  verify_2023_is_not_leap_year(){
        Assert.assertFalse(Exercise.isEven(2023));

    }
    @Test
    void verify_u_is_vowels() {
        Assert.assertTrue(Exercise.isVowels("u"));
    }

    @Test
    void verify_e_is_vowels() {
        Assert.assertTrue(Exercise.isVowels("e"));
    }

    @Test
    void verify_o_is_vowels() {
        Assert.assertTrue(Exercise.isVowels("o"));
    }

    @Test
    void verify_a_is_vowels() {
        Assert.assertTrue(Exercise.isVowels("a"));
    }

    @Test
    void verify_i_is_vowels() {
        Assert.assertTrue(Exercise.isVowels("i"));
    }

    @Test
    void verify_U_is_vowels() {
        Assert.assertTrue(Exercise.isVowels("U"));
    }

    @Test
    void verify_E_is_vowels() {
        Assert.assertTrue(Exercise.isVowels("E"));
    }

    @Test
    void verify_O_is_vowels() {
        Assert.assertTrue(Exercise.isVowels("O"));
    }

    @Test
    void verify_A_is_vowels() {
        Assert.assertTrue(Exercise.isVowels("A"));
    }

    @Test
    void verify_I_is_vowels() {
        Assert.assertTrue(Exercise.isVowels("I"));
    }

    @Test
    void verify_V_is_not_vowels() {
        Assert.assertFalse(Exercise.isVowels("V"));
    }

    @Test
    void verify_v_is_not_vowels() {
        Assert.assertFalse(Exercise.isVowels("v"));
    }

    @Test
    void verify_space_is_not_vowels() {
        Assert.assertFalse(Exercise.isVowels(""));
    }
}
