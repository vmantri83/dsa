package codechef;

import java.util.*;

class C128 {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            long arr[] = new long[(int) n];
            for (int i = 0; i < n; i++)
                arr[i] = in.nextLong();
            Arrays.sort(arr);
            long count = 0L;
            long c = 0L;
            for (long i = 0L; i < n; i++) {
                if (arr[(int) i] == c) {
                    c++;
                    continue;
                } else {
                    if (arr[(int) i] < c) {
                        count += (c - arr[(int) i]);
                        c++;
                    } else {
                        count += (arr[(int) i] - c);
                        c++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
