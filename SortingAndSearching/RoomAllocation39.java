import java.util.*;

class Pair4 {
    int dt;
    int roomId;
    Pair4(int x, int y) {
        this.dt = x;
        this.roomId = y;
    }
}

class Triple1 implements Comparable<Triple1> {
    int at, dt, index;
    Triple1(int at, int dt, int index) {
        this.at = at;
        this.dt = dt;
        this.index = index;
    }

    public int compareTo(Triple1 t2) {
        if (this.at == t2.at) {
            return Integer.compare(this.dt, t2.dt);
        }
        return Integer.compare(this.at, t2.at);
    }
}

public class RoomAllocation39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Triple1> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int at = sc.nextInt();
            int dt = sc.nextInt();
            list.add(new Triple1(at, dt, i));
        }
        Collections.sort(list);
        int[] roomAssigned = new int[n];
        int roomId = 1;
        PriorityQueue<Pair4> pq = new PriorityQueue<>((p1, p2) -> {
            return Integer.compare(p1.dt, p2.dt);
        });

        for (int i = 0; i < n; i++) {
            if (pq.isEmpty()) {
                //assign room
                roomAssigned[list.get(i).index] = roomId;
                pq.add(new Pair4(list.get(i).dt, roomId++));
            } else if (pq.peek().dt < list.get(i).at) {
                //reassign room
                Pair4 pair = pq.poll();
                roomAssigned[list.get(i).index] = pair.roomId;
                pq.add(new Pair4(list.get(i).dt, pair.roomId));
            } else {
                //assign new room
                roomAssigned[list.get(i).index] = roomId;
                pq.add(new Pair4(list.get(i).dt, roomId++));
            }
        }

        System.out.println(roomId - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(roomAssigned[i] + " ");
        }
    }
}
