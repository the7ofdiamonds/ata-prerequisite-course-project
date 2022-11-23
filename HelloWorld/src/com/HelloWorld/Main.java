package com.HelloWorld;

import java.util.Arrays;

public class Main {
    public static void main(String[] arg) {
        int[][] numbers = { {1,2,3}, {4,5,6}};

        numbers[0][0] = 1;

        System.out.println(Arrays.deepToString(numbers));
    }
}