import java.util.*;

public class SlidingMedian51 {
    public static void main(String[] args) {
        SortedSet<Integer> set = new TreeSet<>((a, b) -> Integer.compare(a, b));
        for (int i = 10; i >= 1; i--) {
            set.add(i);
        }
        System.out.println(set.toArray()[1]);
    }
}
