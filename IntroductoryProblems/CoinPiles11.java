import java.util.*;

public class CoinPiles11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long tc = sc.nextLong();

        while (tc-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            if (a > 2 * b || (a + b) % 3 != 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
