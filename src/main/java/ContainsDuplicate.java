package main.java;

import java.util.Arrays;
import java.util.List;

public class ContainsDuplicate {
    public static void main(String[] args) {
        List<int[]> testList = List.of(
                new int[] { 1, 2, 3, 4, 4 },
                new int[] { 1, 2, 3, 4, 5 },
                new int[] { 1, 2, 3, 4, 5, 6, 6 });

        testList.forEach(t -> {
            StopWatch.start();
            String result = hasDuplicates(t);
            long finish = StopWatch.finish();
            System.out.println(Arrays.toString(t) + result + "\n" + "Elapsed time: " + finish + "ns\n");
        });
    }

    private static String hasDuplicates(int[] integers) {
        int count = 0;
        for (int i = 0; i < integers.length; i++) {
            for (int j = 0; j < integers.length; j++) {
                if (integers[i] == integers[j]) {
                    count++;
                    if (count > 1)
                        return " has duplicates";
                }
            }
            count = 0;
        }
        return " does not have duplicates";
    }

}
