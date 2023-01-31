import java.util.*;

public class ReadingBooks42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] times = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            times[i] = sc.nextLong();
            sum += times[i];
        }

        long max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(times[i], max);
        }

        int sumNotMax = 0;
        for (int i = 0; i < n; i++) {
            if (times[i] != max) {
                sumNotMax += times[i];
            }
        }

        System.out.println(Math.max(2 * max, sum));
        sc.close();
    }
}
