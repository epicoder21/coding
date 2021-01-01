package com;

import java.util.ArrayList;
import java.util.List;

public class NearestTime {
    public static void main(String[] args) {
        int[] CurrentTime = {03,56};
        ArrayList<Integer> CTegers = new ArrayList<>();
        CTegers.add(CurrentTime[1] % 10);
        CTegers.add(CurrentTime[0] % 10);
        CTegers.add(CurrentTime[1] / 10);
        CTegers.add(CurrentTime[0] / 10);
        for (int i = 1; i < 24 * 60; i++) {
            CurrentTime[1] = CurrentTime[1] + 1;
            if (CurrentTime[1] == 60) {
                CurrentTime[1] = 00;
                CurrentTime[0] = CurrentTime[0] + 1;
            }
            if (CurrentTime[0] == 24) {
                CurrentTime[0] = 00;
                CurrentTime[1] = 00;
            }
            if (CTegers.contains(CurrentTime[1] % 10)
                    && CTegers.contains(CurrentTime[1] / 10)
                    && CTegers.contains(CurrentTime[0] % 10)
                    && CTegers.contains(CurrentTime[0] / 10)
                    && CurrentTime[1] < 10) {
                System.out.println(CurrentTime[0] + ":" + "0" + CurrentTime[1]);
                break;
            }
            if (CTegers.contains(CurrentTime[1] % 10)
                    && CTegers.contains(CurrentTime[1] / 10)
                    && CTegers.contains(CurrentTime[0] % 10)
                    && CTegers.contains(CurrentTime[0] / 10)) {
                System.out.println(CurrentTime[0] + ":" + CurrentTime[1]);
                break;
            }
        }
    }
}
