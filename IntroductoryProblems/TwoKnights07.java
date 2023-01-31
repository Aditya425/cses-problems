import java.util.*;

public class TwoKnights07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        for (long i = 1; i <= n; i++) {
            if (i == 1) {
                System.out.println(0);
                continue;
            }

            if (i == 2) {
                System.out.println((long)(Math.pow(i, 4) - Math.pow(i, 2)) / 2);
                continue;
            }

            long ac = (long) (Math.pow(i, 4) - Math.pow(i, 2)) / 2;
            long attackEachOther = 2 * 2 * (i - 1) * (i - 2);
			System.out.println(ac - attackEachOther);
        }

        //sc.close();
    }
}
