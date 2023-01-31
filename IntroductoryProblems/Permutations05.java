import java.util.*;

public class Permutations05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        if (n == 1) {
            System.out.println(1);
        } else if (n <= 3) {
            System.out.println("NO SOLUTION");
        } else {
            if (n % 2 == 0) {
                for (long i = 2; i <= n; i+=2) {
                    System.out.print(i + " ");
                }

                for (long i = 1; i < n; i+=2) {
                    System.out.print(i + " ");
                }
            } else {
                for (long i = n - 1; i > 0; i -= 2) {
					System.out.print(i + " ");
				}

				for (long i = n; i > 0; i -= 2) {
					System.out.print(i + " ");
				}
            }
        }

    }
}
