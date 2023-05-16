import java.util.*;

public class MaximumSubarraySumII54 {
    static class Pair {
        long val;
        int ind;
        Pair(long v, int i) {
            this.val = v;
            this.ind = i;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        long[] arr = new long[n];
        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            ps[i + 1] = arr[i] + ps[i];
        }

        SortedSet<Pair> set = new TreeSet<>((p1, p2) -> {
            return Long.compare(p1.val, p2.val);
        });

        for (int i = a; i <= b; i++) {
            set.add(new Pair(ps[i], i));
        }

        long max = Long.MIN_VALUE;

        for (int i = 1; i <= n - a + 1; i++) {
            max = Math.max(set.last().val - ps[i - 1], max);
            set.remove(new Pair(ps[i + a - 1], i + a - 1));
            if (i + b <= n) {
                set.add(new Pair(ps[i + b], i + b));
            }
        }

        System.out.println(max);
        sc.close();
    }
}   
