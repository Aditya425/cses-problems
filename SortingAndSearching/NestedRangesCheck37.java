import java.util.*;

class Triple implements Comparable<Triple> {
    int left, right, index;
    Triple(int left, int right, int index) {
        this.left = left;
        this.right = right;
        this.index = index;
    }

    @Override
    public int compareTo(Triple t2) {
        if (this.left == t2.left) {
            return -1 * Integer.compare(this.right, t2.right);
        }
        return Integer.compare(this.left, t2.left);
    }
}

public class NestedRangesCheck37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Triple> ranges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            ranges.add(new Triple(x, y, i));
        }
        Collections.sort(ranges);
        int[] contains = new int[n];
        int[] contained = new int[n];
        int maxRight = 0;
        for (int i = 0; i < n; i++) {
            Triple t = ranges.get(i);
            if (maxRight >= t.right)  {
                contained[t.index] = 1;
            }
            maxRight = Math.max(maxRight, t.right);
        }
        int minRight = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            Triple t = ranges.get(i);
            if (minRight <= t.right) {
                contains[t.index] = 1;
            }
            minRight = Math.min(minRight, t.right);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(contains[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(contained[i] + " ");
        }
        sc.close();
    }
}