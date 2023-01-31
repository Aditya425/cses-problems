import java.util.*;

public class Towers33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        List<Integer> towers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int square = a[i];
            int ub = upperBound(towers, square);
            // System.out.println(ub);
            if (ub == -1) {
                //no tower found start new tower
                towers.add(square);
            } else {
                //tower found replace that with square
                towers.remove(ub);
                towers.add(square);
            }
        }
        System.out.println(towers.size());
    }    

    private static int upperBound(List<Integer> list, int ele) {
        if (list.size() == 0) {
            return -1;
        }
        Collections.sort(list);
        int s = 0;
        int e = list.size();
        while (s != e) {
            int mid = (s + e) / 2;
            if (list.get(mid) <= ele) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }

        if (s == list.size()) {
            return -1;
        }
        return s;
    }
}
