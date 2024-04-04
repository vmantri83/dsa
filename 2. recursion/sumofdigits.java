import java.util.*;
class sum_of_digits {
    static int sum(int num)
    {
        if(num==0)
        return 0;
        return sum(num/10)+ num%10;
            }
    public static void main(String[] args) {
           int n=8145004;
    int res=sum(n);
        System.out.println(res);
    }
}
