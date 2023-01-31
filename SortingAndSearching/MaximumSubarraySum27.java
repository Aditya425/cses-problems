import java.util.*;

public class MaximumSubarraySum27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        long currentMax = a[0];
        long msf = a[0];

        for (int i = 1; i < n; i++) {
            currentMax += a[i];
            if (currentMax < a[i]) {
                currentMax = a[i];
            }

            if (msf < currentMax) {
                msf = currentMax;
            }
        }

        System.out.println(msf);
    }
}
