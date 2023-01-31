import java.util.*;

public class SubarraySumsII47 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] a = new int[n];
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + a[i];
        }

        Map<Long, Integer> map = new HashMap<>();
        long count = 0;
        for (int i = 0; i <= n; i++) {
            long num = prefixSum[i] - x;
            if (map.containsKey(num)) {
                count += map.get(num);
            }
            map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1);
        }
        System.out.println(count);
        sc.close();
    }
}
