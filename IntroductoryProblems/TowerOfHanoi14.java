import java.util.*;

public class TowerOfHanoi14 {
	public static void solve(int src, int dest, int aux, int n) {
		if (n <= 0) {
			return;
		}
		solve(src, aux, dest, n - 1);
		System.out.println(src + " " + dest);
		solve(aux, dest, src, n - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println((int)Math.pow(2, n) - 1);
		solve(1, 3, 2, n);
	}
}
