package main;

import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;

public class TwoSum {
    public static void main(String[] args) {
        List<int[][]> inputInts = List.of(
                new int[][] { { 1, 2, 3, 4, 5 }, { 9 } },
                new int[][] { { 1, 2, 3, 4, 5 }, { 3 } },
                new int[][] { { 1, 2, 3, 4, 5 }, { 4 } },
                new int[][] { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 }, { 17 } },
                new int[][] { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 }, { 10 } },
                new int[][] { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 }, { 25 } });

        inputInts.forEach(t -> {
            int[] result;
            StopWatch.start();
            result = getSumElemets(t[0], t[1][0]);
            StopWatch.finishReport();
            System.out.println("getSumElemets: " + t[1][0] + " = " + result[0] + " + " + result[1]);

            StopWatch.start();
            result = getSumElemetsAlt(t[0], t[1][0]);
            StopWatch.finishReport();
            System.out.println("getSumElemetsAlt: " + t[1][0] + " = " + result[0] + " + " + result[1]);
        });

    }

    private static int[] getSumElemets(int[] inputInt, int target) {
        for (int i = 0; i < inputInt.length - 1; i++) {
            for (int j = i + 1; j < inputInt.length; j++) {
                if (inputInt[i] + inputInt[j] == target)
                    return new int[] { inputInt[i], inputInt[j] };
            }
        }
        return new int[0];
    }

    private static int[] getSumElemetsAlt(int[] inputInts, Integer target) {
        for(int i = 1; i < inputInts.length; i++) {
            for(int j = 0; j + i < inputInts.length; j++) {
                if(inputInts[j] + inputInts[j + i] == target) {
                    return new int[] {j, j + i};
                }
            }
        }
        return new int[] {};
    }
}