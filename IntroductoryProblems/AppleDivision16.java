import java.util.*;

public class AppleDivision16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] input = new long[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextLong();
        }
		long min = Long.MAX_VALUE;
        for (int mask = 0; mask < (1 << n); mask++) {
            long sumA = 0;
            long sumB = 0;
			String sA = "";
			String sB = "";
            for (int position = 0; position < n; position++) {
                long expAns = mask & (1 << position);
				if (expAns == 0) {
					sumA += input[position];
					sA += input[position] + " - ";
				} else {
					sumB += input[position];
					sB += input[position] + " - ";
				}
				System.out.println(expAns);
            }
			if (min > Math.abs(sumA - sumB)) {
				min = Math.abs(sumA - sumB);
				// System.out.println(sA);
				// System.out.println(sB);
			}
			min = Math.min(min, Math.abs(sumA - sumB));
		}
		System.out.println(min);
    }
}
