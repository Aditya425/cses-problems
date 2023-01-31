import java.util.*;

class Pair6 implements Comparable<Pair6> {
    int num;
    int index;
    Pair6(int num, int index) {
        this.num = num;
        this.index = index;
    }

    @Override
    public int compareTo(Pair6 p2) {
        return Integer.compare(this.num, p2.num);
    }
}

public class SumOfThreeValues43 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        List<Pair6> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            list.add(new Pair6(num, i));
        }

        Collections.sort(list);
        boolean isFound = false;
        int i = 0, j = 0, k = 0;
        for (i = 0; i < n - 2; i++) {
            j = i + 1;
            k = n - 1;
            while (j < k) {
                int sum = list.get(i).num + list.get(j).num + list.get(k).num;
                if (sum == x) {
                    isFound = true;
                    break;
                } else if (sum < x) {
                    j++;
                } else {
                    k--;
                }
            }
            if (isFound) {
                break;
            }
        }
        if (isFound) {
            int[] temp = new int[] {list.get(i).index, list.get(j).index, list.get(k).index};
            Arrays.sort(temp);
            System.out.println((temp[0] + 1) + " " + (temp[1] + 1) + " " + (temp[2] + 1));
        } else {
            System.out.println("IMPOSSIBLE");
        }
        sc.close();
    }
}
