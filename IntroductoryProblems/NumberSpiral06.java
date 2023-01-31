import java.util.*;

public class NumberSpiral06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long tc = sc.nextLong();

        while (tc-- > 0) {
            long y = sc.nextLong(); //row
            long x = sc.nextLong(); //col
            if (y > x) {
                if (y % 2 != 0) {
                    long ans = ((y - 1) * (y - 1)) + x;
                    System.out.println(ans);
                } else {
                    long ans = (y * y) - x - 1;
                    System.out.println(ans);
                }
            } else {
                if (x % 2 == 0) {
					long ans = ((x - 1) * (x - 1)) + y;
					System.out.println(ans);
				} else {
					long ans = (x * x) - y - 1;
					System.out.println(ans);
				}
            }
        }

		sc.close();
    }
}
