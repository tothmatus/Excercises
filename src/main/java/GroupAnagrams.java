package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] input = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> result = createAnaGroups(input);
        System.out.println(result);

        result = createAnaGroupsAlt(input);
        System.out.println(result);
    }

    private static List<List<String>> createAnaGroups(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (wordNotPresent(strs[i], result)) {
                List<String> localGroup = new ArrayList<>();
                localGroup.add(strs[i]);
                for (int j = 1 + i; j < strs.length; j++) {
                    if (isAnagram(strs[j], (strs[i]))) {
                        localGroup.add(strs[j]);
                    }
                }
                if (!localGroup.isEmpty())
                    result.add(localGroup);
            }
        }
        return result;
    }

    private static boolean isAnagram(String a, String b) {
        if (a.length() == b.length()) {
            char[] arrayA = a.toCharArray();
            char[] arrayB = b.toCharArray();
            Arrays.sort(arrayA);
            Arrays.sort(arrayB);
            return Arrays.equals(arrayA, arrayB);
        }
        return false;
    }

    private static boolean wordNotPresent(String word, List<List<String>> list) {
        for (List<String> strings : list) {
            if (strings.contains(word))
                return false;
        }
        return true;
    }

    private static List<List<String>> createAnaGroupsAlt(String[] strs) {
        if (strs.length == 0)
            return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key))
                ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}