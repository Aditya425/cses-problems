import java.util.*;

public class MissingCoinSum29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        long k = 1;
        Arrays.sort(coins);
        for (int i = 0; i < n; i++) {
            if (coins[i] <= k) {
                k += coins[i];
            } else {
                break;
            }
        }
        System.out.println(k);
        sc.close();
    }
}
