import java.util.*;

public class SubarrayDivisibility48 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        long[] prefixSum = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + a[i - 1];
        }

        for (int i = 0; i <= n; i++) {
            if (prefixSum[i] < 0) {
                prefixSum[i] = prefixSum[i] % n + n;
            }
            prefixSum[i] %= n;
        }

        Map<Long, Integer> map = new HashMap<>();
        long count = 0;
        for (int i = 0; i <= n; i++) {
            if (map.containsKey(prefixSum[i])) {
                count += map.get(prefixSum[i]);
            }
            map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1);
        }
        System.out.println(count);
        sc.close();
    }
}
