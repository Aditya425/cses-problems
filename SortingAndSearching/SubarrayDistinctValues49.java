import java.util.*;
import java.math.BigInteger;

public class SubarrayDistinctValues49 {
    private static boolean getCount(Map<Integer, Integer> map, int val) {
        return map.containsKey(val) ? map.get(val) > 0 : false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        BigInteger count = BigInteger.valueOf(0);
        for (int i = 0; i < n; i++) {
            while (j < n && (map.size() <= k)) {
                map.put(a[j], map.getOrDefault(a[j], 0) + 1);
                j++;
            }
            count = count.add(BigInteger.valueOf(j - i - 1));
            if (map.get(a[i]) == 1) {
                map.remove(a[i]);
            } else {
                map.put(a[i], map.get(a[i]) - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        count = count.add(BigInteger.valueOf(map.size()));
        System.out.println(count.longValue());
        sc.close();
    }
}
