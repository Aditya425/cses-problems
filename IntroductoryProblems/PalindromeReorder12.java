import java.util.*;

public class PalindromeReorder12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] chars = new int[26];

        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'A']++;
        }

        int oddFreq = -1;
        for (int i = 0; i < 26; i++) {
            if (chars[i] % 2 != 0) {
                if (oddFreq == -1) {
                    oddFreq = i;
                } else {
                    System.out.println("NO SOLUTION");
                    return;
                }
            }
        }

        if (oddFreq == -1 && s.length() % 2 != 0) {
            System.out.println("NO SOLUTION");
            return;
        }

        if (oddFreq != -1 && s.length() % 2 == 0) {
            System.out.println("NO SOLUTION");
            return;
        }

		String ans = "";

		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < chars[i] / 2; j++) {
				ans += (char)('A' + i);
			}
		}
		System.out.print(ans);
		if (oddFreq != -1) {
			System.out.print((char)('A' + oddFreq));
		}
		
		for (int i = ans.length() - 1; i >= 0; i--) {
			System.out.print(ans.charAt(i));
		}
	}
}
