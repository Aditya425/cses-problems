import java.util.*;

class Pair9 {
    int val;
    int index;
    Pair9(int val, int index) {
        this.val = val;
        this.index = index;
    }
    @Override
    public boolean equals(Object o) {
        Pair9 p = (Pair9) o;
        System.out.println(this.val == p.val && this.index == p.index);
        return this.val == p.val && this.index == p.index;
    }
    @Override
    public int hashCode() {
        return index % 10;
    }
    @Override
    public String toString() {
        return "Pair9 [val=" + val + ", index=" + index + "]";
    }
}

public class SlidingMedian51 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        SortedSet<Pair9> set = new TreeSet<>((d, b) -> Integer.compare(d.val, b.val));

        for (int i = 0; i < k; i++) {
            set.add(new Pair9(a[i], i));
        }

        Pair9 p = (Pair9) set.toArray()[(k - 1) / 2];

        System.out.print(p.val + " ");
        for (int i = 1; i + k - 1 < n; i++) {
            // System.out.println(i);
            set.remove(new Pair9(a[i - 1], i - 1));
            p = new Pair9(a[i + k - 1], i + k - 1);
            set.add(p);
            Pair9 p1 = (Pair9) set.toArray()[(k - 1) / 2];
            System.out.print(p1.val + " ");
        }
        sc.close();
    }
}
