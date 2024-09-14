// https://www.thejoboverflow.com/p/p1879/

import java.util.*;

public class subsequencesort {
    public static List<String> canRearrange(String binary, String[] arr) {
        List<String> results = new ArrayList<>();

        for (String s : arr) {
            if (canMatch(binary, s)) {
                results.add("YES");
            } else {
                results.add("NO");
            }
        }

        return results;
    }

    private static boolean canMatch(String binary, String pattern) {
        int[] binaryCount = new int[2];
        int[] patternCount = new int[2];
        int wildcards = 0;

        for (char c : binary.toCharArray()) {
            binaryCount[c - '0']++;
        }

        for (char c : pattern.toCharArray()) {
            if (c == '?') {
                wildcards++;
            } else {
                patternCount[c - '0']++;
            }
        }

        // Check if the pattern (excluding wildcards) has more of any digit than the
        // binary string
        if (patternCount[0] > binaryCount[0] || patternCount[1] > binaryCount[1]) {
            return false;
        }

        // Check if the total length matches
        return (binaryCount[0] + binaryCount[1] == patternCount[0] + patternCount[1] + wildcards);
    }

    public static void main(String[] args) {
        String binary = "110100";
        String[] arr = { "?110?1", "111???" };

        List<String> results = canRearrange(binary, arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i] + ": " + results.get(i));
        }
    }
}