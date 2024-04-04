
// } Driver Code Ends
import java.util.*;
// User function Template for Java

class reversinggroup {
    // Function to reverse every sub-array group of size k.
    public static void main(String[] args) {
        // code here
        Scanner S = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int n = S.nextInt();
        int k = S.nextInt();
        for (int a = 0; a < n; a++)
            arr.add(S.nextInt());
        int temp = 0, count = 1, r = k;
        for (int i = 0; i < n; i++) {
            while (i < k) {
                temp = arr.get(i);
                arr.set(i, arr.get(k - 1));
                arr.set(k - 1, temp);
                i++;
                k--;
            }
            count++;
            k = (count * r);
            n = n - r;
        }
        for (int j = 0; j < arr.size(); j++)
            System.out.print(arr.get(j) + " ");
    }
}
