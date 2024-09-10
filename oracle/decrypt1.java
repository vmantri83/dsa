
//https://www.thejoboverflow.com/problem/89/


import java.util.*;

class HelloWorld {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        int a = S.nextInt();
        int b = S.nextInt();
        int c = S.nextInt();
        int max = Math.max(a, Math.max(b, c));
        boolean res = false;
        int i;
        for (i = 0; i < max; i++) {
            if (((a | i) & (b | i)) == c) {
                res = true;
                break;
            }

        }
        if (res == true)
            System.out.println(i);
        else
            System.out.println("-1");
    }
}