import java.util.*;

class Pair5 implements Comparable<Pair5> {
    int duration;
    int deadline;

    Pair5(int x, int y) {
        this.duration = x;
        this.deadline = y;
    }

    @Override
    public int compareTo(Pair5 p2) {
        return Integer.compare(this.duration, p2.duration);
    }
}

public class TasksAndDeadlines41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Pair5> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int d = sc.nextInt();
            list.add(new Pair5(a, d));
        }
        Collections.sort(list);

        long time = 0;
        long profit = 0;

        for (int i = 0; i < n; i++) {
            time += list.get(i).duration;
            profit += list.get(i).deadline - time;
        }

        System.out.println(profit);
        sc.close();
    }
}
