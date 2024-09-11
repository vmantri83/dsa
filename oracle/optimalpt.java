// https://www.thejoboverflow.com/p/p1879/
// https://www.geeksforgeeks.org/place-k-elements-such-that-minimum-distance-is-maximized/

import java.util.*;

public class optimalpt {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        int n = S.nextInt();
        int k = S.nextInt();
        int x[] = new int[n];
        for (int i = 0; i < n; i++)
            x[i] = S.nextInt();
        int a = maximumNum(x, n, k);
        System.out.println(a);

    }

    public static int maximumNum(int x[], int n, int k) {
        int low = 1;
        int high = x[n - 1];
        int res = -1;
        Arrays.sort(x);

        while (low < high) {
            int mid = (low + high) / 2;

            if (isFeasible(mid, x, k, n) == true) {
                low = mid + 1;
                res = Math.max(res, mid);
            } else
                high = mid;
        }
        return res;
    }

    public static boolean isFeasible(int mid, int x[], int k, int n) {
        int pos = x[0], count = 1;

        for (int i = 1; i < n; i++) {
            if (x[i] - pos >= mid) {
                count++;
                pos = x[i];
            }

            if (count == k)
                return true;
        }
        return false;
    }
}