import java.util.*;

public class FerrisWheel22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }
        int count = 0;

        Arrays.sort(weights);
        int i = 0;
        int j = n - 1;

        while (i <= j) {
            if (weights[i] + weights[j] <= x) {
                i++;
                j--;
                count++;
            } else {
                j--;
                count++;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
