import java.util.*;

public class SubarraySumsI46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x  =sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int i = 0;
        int j = 0;
        int count = 0;
        long sum = 0;
        while (i < n && j < n) {
            sum += a[i];
            i++;
            while (sum >= x && j < n) {
                if (sum == x) {
                    count++;
                }
                sum -= a[j++];
            }
        }
        System.out.println(count);
        sc.close();
    }
}
