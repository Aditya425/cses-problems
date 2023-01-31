import java.util.*;

class Pair implements Comparable<Pair> {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p2) {
        if (this.x != p2.x) {
            return Integer.compare(this.x, p2.x);
        }

        return Integer.compare(this.y, p2.y);
    }
}

public class ConcertTickets23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Pair> tickets = new ArrayList<>();
        int[] customers = new int[m];

        for (int i = 0; i < n; i++) {
            int ticket = sc.nextInt();
            tickets.add(new Pair(ticket, i));
        }

        for (int i = 0; i < m; i++) {
            customers[i] = sc.nextInt();
        }

        Collections.sort(tickets);

        for (int i = 0; i < m; i++) {
            int customer = customers[i];
            if (tickets.size() == 0) {
                System.out.print(-1);
                continue;
            }
            int lb = lower_bound(tickets, customer + 1);
            // System.out.print("lb = " + lb);
            if (lb == 0 || tickets.size() == 0) {
                System.out.print(-1 + " ");
            } else {
                lb--;
                System.out.print(tickets.get(lb).x + " ");
                tickets.remove(lb);
            }
        }
    }

    static private int lower_bound(List<Pair> list, int key) {
        int low = 0;
        int high = list.size() - 1;

        while (high - low > 1) {
            int mid = (low + high) / 2;
            if (key > list.get(mid).x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        if (list.get(low).x >= key) {
            return low;
        }

        if (list.get(high).x >= key) {
            return high;
        }

        return list.size();
    }
}
