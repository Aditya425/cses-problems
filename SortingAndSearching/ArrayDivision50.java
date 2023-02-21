import java.util.*;
import java.math.BigInteger;

public class ArrayDivision50 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            max = Math.max(max, a[i]);
        }

        BigInteger low = BigInteger.valueOf(max);
        long h = (long) 1e18;
        BigInteger high = BigInteger.valueOf(h);
        BigInteger ans = BigInteger.valueOf(h);

        while (low.longValue() <= high.longValue()) {
            BigInteger mid = low.add(high).divide(BigInteger.valueOf(2));
            long blocks = 1;
            BigInteger sum = BigInteger.valueOf(0);
            for (int i = 0; i < n; i++) {
                if (sum.add(BigInteger.valueOf(a[i])).longValue() > mid.longValue()) {
                    sum = BigInteger.valueOf(0);
                    blocks++;
                }
                sum = sum.add(BigInteger.valueOf(a[i]));
            }

            if (blocks > k) {
                low = mid.add(BigInteger.valueOf(1));
            } else {
                ans = mid;
                high = mid.subtract(BigInteger.valueOf(1));
            }
        }

        System.out.println(ans);
        sc.close();
    }
}
