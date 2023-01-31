import java.util.*;

class Pair8 {
    int num;
    int index;
    Pair8(int num, int index) {
        this.num = num;
        this.index = index;
    }
}

public class NearestSmallerValues45 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Stack<Pair8> pq = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty() && pq.peek().num >= nums[i]) {
                pq.pop();
            }
            if (pq.isEmpty()) {
                System.out.print("0 ");
            } else {
                System.out.print(pq.peek().index + " ");
            }
            pq.add(new Pair8(nums[i], i + 1));
        }
    }
}
