/*
https://cses.fi/problemset/task/1094
https://www.youtube.com/watch?v=PGbmyMMLJVA&list=PLcXpkI9A-RZLNzhkMB3SyNfagr1LzIGrp&index=4

you're given a list of numbers. our task is to modify the array in such a way that it is increasing in order. It need not be strictly increasing i.e 2 elements can be equal. The modifications allowed here are that we can increment an element by any number to make it >= to the previous element. We have to print what are the minimum number of incrementations required to make it increasing.
Eg:
5 (the number of elements)
3 2 5 1 7 (the elements)
ans=5
explanation:
consider array as a. We loop through the array and we start from a[1]. a[1] < a[0]. To make a[1] >= a[0] add 1 to a[1] i.e 2+1 i.e 3. Now the array will become 3,3,5,1,7 and it is fine until this point. Also make a note of the incrementations you did i.e sum=1
Next, a[2] is already >= a[1] so we need not do anything
Next, a[3] < a[2]. We need to add (a[3]-a[2]) i.e 4 needs to be added to a[3] to make it >= a[2]. So 1+4=5. The array is 3,3,5,5,7. The sum will now become sum+4, 1+4, sum=5
Next a[4] is already >= to a[3] so nothing needs to be done.
Our final ans is sum i.e 5
Basically do this:
 if curr<prev: the incrementation that must be made is (prev-curr) and add this value to sum
*/

import java.util.*;

public class IncreasingArray04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] a = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                sum += Math.abs(a[i] - a[i + 1]);
                a[i + 1] = a[i];
            }
        }

        System.out.println(sum);
        sc.close();
    }
}
