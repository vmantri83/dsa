import java.util.*;
import java.util.Scanner;
class palindrome_recursion {
    static boolean isPalin(String str, int start, int end)
    {
        if(start>=end)
        return true;
        return(str.charAt(start)==str.charAt(end) && isPalin(str,start+1,end-1));
    }
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String st = S.nextLine();
        int s = 0;
        int e = st.length() - 1;
        boolean x = isPalin(st, s, e);
        System.out.println(x);
    }
}
