import java.util.*;

public class JosephusProblemI35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        List<Integer> survivors = new ArrayList<>();
        while (!list.isEmpty()) {
            survivors.clear();
            for (int i = 0; i < list.size(); i++) {
                if (i % 2 == 1) {
                    System.out.print(list.get(i) + " ");
                } else {
                    survivors.add(list.get(i));
                }
            }
            if (list.size() == 1) {
                System.out.print(list.get(0));
                break;
            }
            if (list.size() % 2 == 0) {
                list.clear();
                list.addAll(survivors);
            } else {
                int first = survivors.get(survivors.size() - 1);
                list.clear();
                list.add(first);
                for (int i = 0; i < survivors.size() - 1; i++) {
                    list.add(survivors.get(i));
                }
            }
        }
        sc.close();
    }
}
