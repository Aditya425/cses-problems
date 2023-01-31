import java.util.*;

public class JosephusProblemII36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 1; i <= n; i++) {
            set.add(i);
        }

        int startPos = 0;

        while (set.size() > 0) {
            startPos = startPos % set.size();
            int posToRemove = (startPos + k) % set.size();
            startPos = posToRemove;
            Integer ele = (Integer) set.toArray()[posToRemove];
            System.out.print(ele + " ");
            set.remove(ele);
        }
        sc.close();
    }
}
