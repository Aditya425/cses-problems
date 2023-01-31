import java.util.*;

public class IncreasingArray04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] a = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                sum += Math.abs(a[i] - a[i + 1]);
                a[i + 1] = a[i];
            }
        }

        System.out.println(sum);
        sc.close();
    }
}
