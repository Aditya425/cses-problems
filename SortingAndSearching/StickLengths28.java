import java.util.*;

public class StickLengths28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);
        long cost = 0;
        if (n % 2 != 0) {
            for (int i = 0; i < n; i++) {
                cost += Math.abs(a[i] - a[n / 2]);
            }
        } else {
            long cost1 = 0;
            long cost2 = 0;
            for (int i = 0; i < n; i++) {
                cost1 += Math.abs(a[i] - a[n / 2]);
                cost2 += Math.abs(a[i] - a[(n / 2) - 1]);
            }
            cost = Math.min(cost1, cost2);
        }
        System.out.println(cost);
        sc.close();

    }
}
