package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        List<String[]> testCase = List.of(
                new String[] { "anagram", "nagaram" },
                new String[] { "anagrame", "nagarame" },
                new String[] { "anagrame", "nagarami" },
                new String[] { "anagram", "nagaramn" });

        testCase.forEach(t -> {
            boolean result;

            StopWatch.start();
            result = isAnagram(t[0], t[1]);
            StopWatch.finishReport();
            System.out.println("isAnagram: " + result);

            StopWatch.start();
            result = isAnagramAlternative(t[0], t[1]);
            StopWatch.finishReport();
            System.out.println("AnagramAlternative: " + result);
        });

    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() == t.length()) {
            char[] sArray = s.toCharArray();
            char[] tArray = t.toCharArray();
            Arrays.sort(sArray);
            Arrays.sort(tArray);
            return Arrays.equals(sArray, tArray);
        }
        return false;
    }

    private static boolean isAnagramAlternative(String s, String t) {
        if (s.length() == t.length()) {
            int[] frequency = new int[26];
            for (int i = 0; i < s.length(); i++) {
                int letterS = s.charAt(i) - 'a';
                int letterT = t.charAt(i) - 'a';
                frequency[letterS]++;
                frequency[letterT]--;
            }
            return Arrays.stream(frequency).sum() == 0;
        }
        return false;
    }
}
