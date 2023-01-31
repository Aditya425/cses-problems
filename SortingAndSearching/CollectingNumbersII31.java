import java.util.*;

class Pair3 {
    int i;
    int j;

    Pair3(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object obj) {
        Pair3 p2 = (Pair3) obj;
        return i == p2.i && j == p2.j;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + i;
        hash = 31 * hash + j;
        return hash;
    }

    @Override
    public String toString() {
        return this.i + " " + this.j;
    }
}

public class CollectingNumbersII31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        Set<Pair3> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            map.put(a[i], i);
        }

        // initial conflicts

        int count = 1;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(a[i] + 1) && map.get(a[i]) > map.get(a[i] + 1)) {
                count++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int p = sc.nextInt() - 1;
            int q = sc.nextInt() - 1;
            // add affected values in set
            if (a[p] + 1 <= n) {
                Pair3 p1 = new Pair3(a[p], a[p] + 1);
                if (!set.contains(p1)) {
                    set.add(p1);
                }
            }

            if (a[p] - 1 >= 1) {
                Pair3 p1 = new Pair3(a[p] - 1, a[p]);
                if (!set.contains(p1))
                    set.add(p1);
            }

            if (a[q] + 1 <= n) {
                Pair3 p1 = new Pair3(a[q], a[q] + 1);
                if (!set.contains(p1))
                    set.add(p1);
            }

            if (a[q] - 1 >= 1) {
                Pair3 p1 = new Pair3(a[q] - 1, a[q]);
                if (!set.contains(p1))
                    set.add(p1);
            }

            // undo changes
            for (Pair3 pair : set) {
                int num1 = pair.i;
                int num2 = pair.j;
                if (num1 < num2) {
                    if (map.get(num1) > map.get(num2)) {
                        count--;
                    }
                } else {
                    if (map.get(num2) > map.get(num1)) {
                        count--;
                    }
                }
            }

            // swap
            map.put(a[p], q);
            map.put(a[q], p);
            int temp = a[p];
            a[p] = a[q];
            a[q] = temp;

            for (Pair3 pair : set) {
                int num1 = pair.i;
                int num2 = pair.j;
                if (num1 < num2) {
                    if (map.get(num1) > map.get(num2)) {
                        count++;
                    }
                } else {
                    if (map.get(num2) > map.get(num1)) {
                        count++;
                    }
                }
            }
            set.clear();
            ans.add(count);
        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
        sc.close();
    }
}
