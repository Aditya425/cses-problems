import java.util.*;

public class Playlist32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        int i = 0;
        int j = 0;
        Set<Long> set = new HashSet<>();
        long ans = 0; 
        while (i < n && j < n) {
            while (j < n && !set.contains(a[j])) {
                set.add(a[j]);
                ans = Math.max(ans, j - i + 1);
                j++;
            }
            set.remove(a[i]);
            i++;
        }

        System.out.println(ans);
    }
}
