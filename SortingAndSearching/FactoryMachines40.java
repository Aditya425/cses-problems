import java.util.*;

public class FactoryMachines40 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] machines = new int[n];
        for (int i = 0; i < n; i++) {
            machines[i] = sc.nextInt();
        }
        long low = 0;
        long high = (long) 1e18;
        long ans = (long) 1e18;
        while (low <= high) {
            long mid = (low + high) / 2;
            long products = 0;
            for (int i = 0; i < n; i++) {
                products += Math.min(mid / machines[i], 1e18);
            }

            if (products >= t) {
                ans = Math.min(mid, ans);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(ans);
        sc.close();
    }
}
