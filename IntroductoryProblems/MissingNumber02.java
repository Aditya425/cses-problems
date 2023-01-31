import java.util.*;

public class MissingNumber02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            long num = sc.nextLong();
            sum = sum + num;
        }

        long ans = (n * (n + 1) / 2) - sum;
        System.out.println(ans);
    }
}
