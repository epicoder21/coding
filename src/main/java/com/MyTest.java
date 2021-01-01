package com;

import java.util.Arrays;

public class MyTest {
    public static void main(String[] args) {

        int[][] twoarr = new int[3][3];
        twoarr[0] = new int[]{1,1,0};
        twoarr[1] = new int[]{0,0,0};
        twoarr[2] = new int[]{1,0,1};
        if (twoarr[0][0] == twoarr[0][1] && twoarr[0][1] == twoarr[0][2]) {
            if (twoarr[0][0] == 1){
                System.out.println(Arrays.deepToString(twoarr) + "A wins!");
            }else {
                System.out.println(Arrays.deepToString(twoarr) + "B wins!");
            }

        }
        if (twoarr[1][0] == twoarr[1][1] && twoarr[1][1] == twoarr[1][2]) {
            if (twoarr[1][0] == 1){
                System.out.println(Arrays.deepToString(twoarr) + "A wins!");
            }else {
                System.out.println(Arrays.deepToString(twoarr) + "B wins!");
            }

        }
        if (twoarr[2][0] == twoarr[2][1] && twoarr[2][1] == twoarr[2][2]) {
            if (twoarr[2][0] == 1){
                System.out.println(Arrays.deepToString(twoarr) + "A wins!");
            }else {
                System.out.println(Arrays.deepToString(twoarr) + "B wins!");
            }

        }
//       vertical
        if (twoarr[0][0] == twoarr[1][0] && twoarr[1][0] == twoarr[2][0]) {
            if (twoarr[0][0] == 1){
                System.out.println(Arrays.deepToString(twoarr) + "A wins!");
            }else {
                System.out.println(Arrays.deepToString(twoarr) + "B wins!");
            }

        }
        if (twoarr[0][1] == twoarr[1][1] && twoarr[1][1] == twoarr[2][1]) {
            if (twoarr[0][1] == 1){
                System.out.println(Arrays.deepToString(twoarr) + "A wins!");
            }else {
                System.out.println(Arrays.deepToString(twoarr) + "B wins!");
            }

        }
        if (twoarr[0][2] == twoarr[1][2] && twoarr[1][2] == twoarr[2][2]) {
            if (twoarr[0][2] == 1){
                System.out.println(Arrays.deepToString(twoarr) + "A wins!");
            }else {
                System.out.println(Arrays.deepToString(twoarr) + "B wins!");
            }

        }
//        diagonal
        if (twoarr[0][0] == twoarr[1][1] && twoarr[1][1] == twoarr[2][2]) {
            if (twoarr[0][0] == 1){
                System.out.println(Arrays.deepToString(twoarr) + "A wins!");
            }else {
                System.out.println(Arrays.deepToString(twoarr) + "B wins!");
            }
        }
        if (twoarr[0][2] == twoarr[1][1] && twoarr[1][1] == twoarr[2][0]) {
            if (twoarr[0][2] == 1){
                System.out.println(Arrays.deepToString(twoarr) + "A wins!");
            }else {
                System.out.println(Arrays.deepToString(twoarr) + "B wins!");
            }
        }
    }
}

//        [[1, 1, 0],
//        [1, 0, 1],
//        [0, 0, 1]]A wins!
