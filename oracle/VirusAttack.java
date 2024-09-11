// https://www.thejoboverflow.com/problem/71/

import java.util.*;

public class VirusAttack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int N = sc.nextInt(); // Size of array A
            String[] array = new String[N];
            for (int i = 0; i < N; i++) {
                array[i] = sc.next();
            }

            long[] weights = new long[26];
            boolean[] isLeading = new boolean[26];

            // Calculate weights for each character
            for (String str : array) {
                int len = str.length();
                for (int i = 0; i < len; i++) {
                    char ch = str.charAt(i);
                    if (Character.isLetter(ch)) {
                        weights[ch - 'A'] += (long) Math.pow(10, len - i - 1);
                        if (i == 0)
                            isLeading[ch - 'A'] = true;
                    }
                }
            }

            // Create a list of characters and sort by weight
            List<Integer> charList = new ArrayList<>();
            for (int i = 0; i < 26; i++)
                if (weights[i] > 0)
                    charList.add(i);
            charList.sort((a, b) -> Long.compare(weights[b], weights[a]));

            // Assign digits to characters
            int[] digitMap = new int[26];
            Arrays.fill(digitMap, -1);
            boolean[] usedDigits = new boolean[10];

            // Assign non-zero digits first
            for (int ch : charList) {
                if (isLeading[ch]) {
                    for (int digit = 1; digit <= 9; digit++) {
                        if (!usedDigits[digit]) {
                            digitMap[ch] = digit;
                            usedDigits[digit] = true;
                            break;
                        }
                    }
                }
            }

            // Assign remaining digits
            for (int ch : charList) {
                if (digitMap[ch] == -1) {
                    for (int digit = 0; digit <= 9; digit++) {
                        if (!usedDigits[digit]) {
                            digitMap[ch] = digit;
                            usedDigits[digit] = true;
                            break;
                        }
                    }
                }
            }

            // Decode the array and calculate the sum
            long totalSum = 0;
            for (String str : array) {
                long num = 0;
                for (char ch : str.toCharArray()) {
                    if (Character.isLetter(ch)) {
                        num = num * 10 + digitMap[ch - 'A'];
                    } else {
                        num = num * 10 + (ch - '0');
                    }
                }
                totalSum += num;
            }

            // Output the result
            System.out.println(totalSum);
        }
        sc.close();
    }
}
