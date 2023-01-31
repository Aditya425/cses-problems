import java.util.*;

public class TwoSets08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long sum = (n * (n + 1)) / 2;
        if (sum % 2 == 1) {
            System.out.println("NO");
        } else {
			System.out.println("YES");
            Long t = n;
            Set<Long> set1 = new HashSet<>();
            Set<Long> set2 = new HashSet<>();
            long target = sum / 2;
            for (long i = 1; i <= t; i++) {
                set1.add(i);
            }

            while (!set1.contains(target)) {
                target = target - t;
                set2.add(t);
				set1.remove(t);
				t--;
            }
			set1.remove(target);
			set2.add(target);
			System.out.println(set1.size());
			for (long l : set1) {
				System.out.print(l + " ");
			}
			System.out.println();
			System.out.println(set2.size());
			for (long l : set2) {
				System.out.print(l + " ");
			}
        }
    }
}
