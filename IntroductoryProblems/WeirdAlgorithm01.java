import java.util.*;

class WeirdAlgorithm01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = Long.parseLong(sc.nextLine());
        System.out.print(n + " ");
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n * 3;
                n += 1;
            }
            System.out.print(n + " ");
        }
        sc.close();
    }
}

