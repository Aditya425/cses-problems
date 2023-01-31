import java.util.*;

public class SumOfTwoValues26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int diff = target - a[i];
            if (map.containsKey(diff)) {
                System.out.print(map.get(diff) + 1 + " ");
                System.out.print(i + 1 + " ");
                return;
            } else {
                map.put(a[i], i);
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
