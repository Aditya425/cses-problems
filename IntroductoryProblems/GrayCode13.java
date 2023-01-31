import java.util.*;

public class GrayCode13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        long n = sc.nextLong();
        List<String> res = recursion(n);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    static List<String> recursion(long n) {
        if (n == 1) {
            List<String> l = new ArrayList<>();
            l.add("0");
            l.add("1");
            return l;
        }
        List<String> rr = recursion(n - 1);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < rr.size(); i++) {
            String rrs = rr.get(i);
            res.add("0" + rrs);
        }

        for (int i = rr.size() - 1; i >= 0; i--) {
            String rrs = rr.get(i);
            res.add("1" + rrs);
        }

        return res;
    }
}
