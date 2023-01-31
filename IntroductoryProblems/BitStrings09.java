import java.util.*;

public class BitStrings09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long mod = 1000000007;
        long ans = 1;
        for (long i = 0; i < n; i++) {
            ans *= 2;
            ans = ans % mod;
        }
        System.out.println(ans);
    }
}
