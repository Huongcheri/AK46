package org.example;

public class Exercise {
    public static boolean isEven(int number){
        return number % 2 == 0;
    }

    public static boolean isLeapYear(int year){
        return (year % 4 == 0 && 100 != 0 ) ;
    }

    public static boolean isVowels( String vowels ){
        if (vowels.length() != 0) {
            return (vowels.matches("([ueoaiUEOAI])"));
        }
        return false;
    }


}
