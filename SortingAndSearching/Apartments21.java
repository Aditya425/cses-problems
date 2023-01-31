import java.util.*;

public class Apartments21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] desiredApartmentsSize = new int[n];
        int[] apartmentSize = new int[m];
        for (int i = 0; i < n; i++) {
            desiredApartmentsSize[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            apartmentSize[i] = sc.nextInt();
        }

        Arrays.sort(desiredApartmentsSize);
        Arrays.sort(apartmentSize);

        int i = 0;
        int j = 0;
        int count = 0;
        while (i < desiredApartmentsSize.length && j < apartmentSize.length) {
            int lb = desiredApartmentsSize[i] - k;
            int ub = desiredApartmentsSize[i] + k;
            if (apartmentSize[j] < lb) {
                j++;
                continue;
            }

            if (apartmentSize[j] > ub) {
                i++;
                continue;
            }

            if (apartmentSize[j] >= lb && apartmentSize[j] <= ub) {
                count++;
                i++;
                j++;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
