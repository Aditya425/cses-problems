import java.util.*;

public class Repetitions03 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		int max = 1;
		int c = 1;

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i - 1) == s.charAt(i)) {
				c++;
				max = Math.max(c, max);
			} else {
				c = 1;
				max = Math.max(max, c);
			}
		}

		System.out.println(max);
	}
}
