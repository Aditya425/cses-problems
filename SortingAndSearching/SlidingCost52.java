import java.util.*;

public class SlidingCost52 {
    static class Pair {
        int num;
        int index;

        Pair(int num, int index) {
            this.num = num;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Pair [num=" + num + ", index=" + index + "]";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<SlidingCost52.Pair> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(new SlidingCost52.Pair(nums[i], i));
        }

        Collections.sort(list, (a, b) -> {
            return Integer.compare(a.num, b.num);
        });
        SortedSet<SlidingCost52.Pair> leftSet = new TreeSet<>((a, b) -> {
            if (a.num == b.num) {
                return Integer.compare(a.index, b.index);
            }
            return Integer.compare(a.num, b.num);
        });
        SortedSet<SlidingCost52.Pair> rightSet = new TreeSet<>((a, b) -> {
            if (a.num == b.num) {
                return Integer.compare(a.index, b.index);
            }
            return Integer.compare(a.num, b.num);
        });

        if (k == 1) {
            for (int i = 0; i < n - k + 1; i++) {
                System.out.print(0 + " ");
            }
            sc.close();
            return;
        }

        if (k == 2) {
            for (int i = 1; i <= n - k + 1; i++) {
                System.out.print(Math.abs(nums[i] - nums[i - 1]) + " ");
            }
            sc.close();
            return;
        }

        long lss = 0;
        long rss = 0;
        for (int i = 0; i < (k / 2) + (k % 2); i++) {
            lss += list.get(i).num;
            leftSet.add(list.get(i));
        }

        for (int i = (k / 2) + (k % 2); i < k; i++) {
            rss += list.get(i).num;
            rightSet.add(list.get(i));
        }
        
        int median = leftSet.last().num;
        System.out.print(leftSet.size() * median - lss + rss - rightSet.size() * median + " ");
        for (int i = 1; i < n - k + 1; i++) {
            if (leftSet.contains(new SlidingCost52.Pair(nums[i - 1], i - 1))) {
                lss -= nums[i - 1];
                leftSet.remove(new SlidingCost52.Pair(nums[i - 1], i - 1));
            } else if (rightSet.contains(new SlidingCost52.Pair(nums[i - 1], i - 1))) {
                rss -= nums[i - 1];
                rightSet.remove(new SlidingCost52.Pair(nums[i - 1], i - 1));
            }
            if (nums[i + k - 1] > leftSet.last().num) {
                rightSet.add(new SlidingCost52.Pair(nums[i + k - 1], i + k - 1));
                rss += nums[i + k - 1];
            } else {
                leftSet.add(new SlidingCost52.Pair(nums[i + k - 1], i + k - 1));
                lss += nums[i + k - 1];
            }

            while (rightSet.size() >= (k / 2) + (k % 2)) {
                SlidingCost52.Pair p = rightSet.first();
                leftSet.add(p);
                lss += p.num;
                rightSet.remove(p);
                rss -= p.num;
            }

            
            while (leftSet.size() > (k / 2) + (k % 2)) {
                SlidingCost52.Pair p = leftSet.last();
                rightSet.add(p);
                rss += p.num;
                lss -= p.num;
                leftSet.remove(p);
            }

            median = leftSet.last().num;
            System.out.print(leftSet.size() * median - lss + rss - rightSet.size() * median + " ");
        }
        sc.close();
    }
}
