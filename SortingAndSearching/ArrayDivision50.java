import java.util.*;

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

        long low = max;
        long h = (long) 1e18;
        long high = h;
        long ans = h;

        while (low <= high) {
            long mid = (low + high) / 2;
            long blocks = 1;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (sum + a[i] > mid) {
                    sum = 0;
                    blocks++;
                }
                sum += a[i];
            }

            if (blocks > k) {
                low = mid + 1;
            } else {
                ans = Math.min(ans, mid);
                high = mid - 1;
            }
        }

        System.out.println(ans);
        sc.close();
    }
}
