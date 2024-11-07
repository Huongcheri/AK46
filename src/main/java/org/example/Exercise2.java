package org.example;

import java.util.Arrays;

public class Exercise2 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 9, 0, 2, 8};
        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println(max);
        int min = Arrays.stream(arr).min().getAsInt();
        System.out.println(min);
//
//        List<Integer> list = Arrays.stream(arr).boxed().toList();
//        int maxIndex = list.indexOf(max);
//        System.out.println(maxIndex);

    }
}
