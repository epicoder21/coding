package com;

import java.util.Arrays;

public class Easy {
    public static void main(String[] args) {
        char[] reverse = {'L'};

        for (int i = 0; i < reverse.length/2; i++) {
            char placeholder = reverse[reverse.length-1-i];
            System.out.println(placeholder);
            System.out.println(reverse.length/2);
            reverse[reverse.length-1-i] = reverse[i];
            reverse[i] = placeholder;
        }
        System.out.println(Arrays.toString(reverse));
    }
}