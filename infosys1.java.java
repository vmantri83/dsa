import java.util.*;

class HelloWorld {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        int vno = S.nextInt();
        int hno = S.nextInt();
        int hp = S.nextInt();
        int vp[] = new int[vno];
        int sum = 0;
        for (int i = 0; i < vno; i++) {
            vp[i] = S.nextInt();
            sum = sum + vp[i];
        }
        if ((hp * hno) >= sum)
            System.out.println("0");
        else {
            for (int i = vno - 1; i >= 0; i--) {
                if ((hp * hno) - vp[i] > 0) {
                    hp = hp - vp[i];
                    continue;
                } else {
                    System.out.println();
                    if (hp == 0) {
                        System.out.println(i);
                    } else {
                        System.out.println(i + 1);
                    }
                    break;
                }
            }
        }
    }
}