import java.util.*;

public class ChessboardAndQueens17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[8][8];
		int count = 0;
        for (int i = 0; i < 8; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < 8; j++) {
                board[i][j] = input.charAt(j);
            }
        }
        int[] column = new int[8];
		int[] originalColumn = new int[8];
        for (int i = 0; i < 8; i++) {
            column[i] = i;
			originalColumn[i] = i;
        }

		while (true) {
			column = nextPermutation(column);
			boolean valid = true;
			if (Arrays.equals(column, originalColumn)) {
				break;
			}
			for (int i = 0; i < 8; i++) {
				if (board[i][column[i]] == '*') {
					valid = false;
					break;
				}
			}
			boolean[] diagonalColumn = new boolean[15];
			//left diagonal
			for (int i = 0; i < 8; i++) {
				if (diagonalColumn[i + column[i]]) {
					valid = false;
				}
				diagonalColumn[i + column[i]] = true;
			}
			Arrays.fill(diagonalColumn, false);
			for (int i = 0; i < 8; i++) {
				if (diagonalColumn[7 + column[i] - i]) {
					valid = false;
				}
				diagonalColumn[7 + column[i] - i] = true;
			}

			if (valid) {
				count++;
			}
		}

		System.out.println(count);
    }

	private static int[] swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		return nums;
	}

	private static int[] reverse(int[] nums, int i, int j) {
		while (j >= i) {
			nums = swap(nums, i++, j--);
		}
		return nums;
	}

	private static int[] nextPermutation(int[] nums) {
		int n = nums.length;
		int i = n - 2;
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		if (i < 0) {
			return reverse(nums, 0, n - 1);
		}

		int j = n - 1;
		while (j > i && nums[j] <= nums[i]) {
			j--;
		}

		nums = swap(nums, i, j);
		return reverse(nums, i + 1, n - 1);
	}
}
