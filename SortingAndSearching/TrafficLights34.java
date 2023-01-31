import java.util.*;

public class TrafficLights34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        PriorityQueue<Integer> sorted = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a, b);
        });
        sorted.add(0);
        sorted.add(x);
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> {
            return -1 * Integer.compare(a, b);
        });
        max.add(x - 0);
        List<Integer> sortedList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int trafficLightPos = sc.nextInt();
            sorted.add(trafficLightPos);
            while (!sorted.isEmpty()) {
                if (!sortedList.contains(sorted.peek()))
                    sortedList.add(sorted.poll());
            }
            int prev = sortedList.get(sortedList.indexOf(trafficLightPos) - 1);
            int next = sortedList.get(sortedList.indexOf(trafficLightPos) + 1);
            max.remove(next - prev);
            max.add(trafficLightPos - prev);
            max.add(next - trafficLightPos);
            // System.out.println(sortedList);
            System.out.println(max.peek());
            sorted.addAll(sortedList);
            sortedList.clear();
        }

        sc.close();
    }
}
