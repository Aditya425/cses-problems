import java.util.*;

class Pair1 implements Comparable<Pair1> {
    int x;
    int y;

    Pair1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
    @Override
    public int compareTo(Pair1 p2) {
        return Integer.compare(this.x, p2.x);
    }

    
}

public class RestaurantCustomers24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pair1> list = new ArrayList<>();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.add(new Pair1(x, 1));
            list.add(new Pair1(y, -1));
        }

        Collections.sort(list);
        int max = 0;
        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).y;
            max = Math.max(sum, max);
        }

        System.out.println(max);
        sc.close();
    }
}
