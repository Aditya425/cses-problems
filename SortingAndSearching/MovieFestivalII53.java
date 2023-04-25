import java.util.*;

public class MovieFestivalII53 {
    static class Pair {
        int start;
        int end;
        Pair(int s, int e) {
            this.start = s;
            this.end = e;
        }
        @Override
        public String toString() {
            return "Pair [start=" + start + ", end=" + end + "]";
        }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Pair> movies = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            movies.add(new Pair(s, e));
        }
        Collections.sort(movies, (a, b) -> {
            if (a.end == b.end) {
                return Integer.compare(a.start, b.start);
            }
            return Integer.compare(a.end, b.end);
        });
        SortedSet<Pair> set = new TreeSet<>((a, b) -> Integer.compare(a.start, b.start));
        int badMoviesCount = 0;
        for (int i = 0; i < n; i++) {
            movies.set(i, new Pair(-1 * movies.get(i).start, movies.get(i).end));
            if (set.isEmpty()) {
                set.add(new Pair(-1 * movies.get(i).end, i));
            } else if (!set.tailSet(movies.get(i)).isEmpty()) {
                Pair lastMovie = set.tailSet(movies.get(i)).first();
                set.remove(lastMovie);
                set.add(new Pair(-1 * movies.get(i).end, i));
            } else if (set.tailSet(movies.get(i)).isEmpty() && set.size() < k) {
                set.add(new Pair(-1 * movies.get(i).end, i));
            } else {
                badMoviesCount++;
            }
        }
        System.out.println(n - badMoviesCount);
        sc.close();
    }
}
