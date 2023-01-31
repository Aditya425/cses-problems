import java.util.*;

class Pair2 implements Comparable<Pair2> {
    int start;
    int end;

    Pair2(int x, int y) {
        this.start = x;
        this.end = y;
    }

    public int compareTo(Pair2 p2) {
        if (this.end == p2.end) {
            return Integer.compare(this.start, p2.start);
        }

        return Integer.compare(this.end, p2.end);
    }

    @Override
    public String toString() {
        return "[start = " + start + ", end = " + end + "]";
    }
}

public class MovieFestival25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Pair2> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            list.add(new Pair2(start, end));
        }

        Collections.sort(list);
        // System.out.println(list);
        int lmft = -1;
        int count = 0;
        for (Pair2 p : list) {
            if (p.start >= lmft) {
                count++;
                lmft = p.end;
            }
        }
        sc.close();
        System.out.println(count);
    }
}
