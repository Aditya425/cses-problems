import java.util.*;

public class CreatingStrings15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int[] charArr = new int[] {1, 3, 2};
		Arrays.sort(charArr);
		//String originalString = new String(charArr);
		
		List<String> permutations = new ArrayList<>();
		//permutations.add(originalString);
		System.out.println(nextPermutation(charArr));
		// while (true) {
		// 	String np = nextPermutation(charArr);
		// 	if (np.equals(originalString)) {
		// 		break;
		// 	}
		// 	permutations.add(np);
		// 	charArr = np.toCharArray();
			
		// }
		sc.close();
    }

	private static String nextPermutation(int[] nums) {
		int n = nums.length;
		int i = n - 2;
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		if (i < 0) {
			nums = reverse(nums, 0, n - 1);
			String ans = "";
			for (int num : nums) {
				ans += num;
			}
			return ans;
		}

		int j = n - 1;
		while (j >= i && nums[j] <= nums[i]) {
			j--;
		}
		
		nums = swap(nums, i, j);
		System.out.println(Arrays.toString(nums));
		nums = reverse(nums, i, n - 1);
		String ans = "";
		for (int num : nums) {
			ans += num;
		}
		return ans;
	}

	private static int[] reverse(int[] nums, int i, int j) {
		while (j >= i) {
			swap(nums, i++, j--);
		}
		return nums;
	}

	private static int[] swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		return nums;
	}
}
