import java.util.*;

public class TrailingZeroes10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long powerFive = 5;
        long ans = 0;

        while (powerFive <= n) {
            n = n / powerFive;
            ans += n;
        }    

        System.out.println(ans);
    }
}
