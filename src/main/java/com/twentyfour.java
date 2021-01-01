package com;

public class twentyfour {
    public static void main(String[] args) {
        int[] selection = {4, 12, 12, 4};
        boolean isAnswer = false;
        for (int a = 0; a < 2; a++) {
            for (int b = 0; b < 2; b++) {
                for (int c = 0; c < 2; c++) {
                    for (int d = 0; d < 2; d++) {
                        int sum = 0;
                        String Output = "";
                        if (a != 0) {
                            sum = sum - selection[0];
                            Output = Output + -selection[0];
                        } else {
                            sum = sum + selection[0];
                            Output = Output + selection[0];
                        }
                        if (b != 0) {
                            sum = sum - selection[1];
                            Output = Output + -selection[1];
                        } else {
                            sum = sum + selection[1];
                            Output = Output + "+" + selection[1];
                        }
                        if (c != 0) {
                            sum = sum - selection[2];
                            Output = Output + -selection[2];
                        } else {
                            sum = sum + selection[2];
                            Output = Output + "+" + selection[2];
                        }
                        if (d != 0) {
                            sum = sum - selection[3];
                            Output = Output + -selection[3];
                        } else {
                            sum = sum + selection[3];
                            Output = Output + "+" + selection[3];
                        }
                        if (sum == 24) {
                            System.out.println(Output);
                            isAnswer = true;
                        }
                    }
                }
            }
        }
        if (isAnswer == false) {
            System.out.println("No Answer. :(");
        }
    }
}
