//https://cses.fi/problemset/task/1068/
//https://www.youtube.com/watch?v=A9C7rO_R888&list=PLcXpkI9A-RZLNzhkMB3SyNfagr1LzIGrp

import java.util.*;

/*consider an algorithm: we input a positive int n. n can be even or odd
    even: divide the number by 2
    odd: multiply the number by 3 and add 1

our task is to simulate this algorithm until n becomes 1. For eg: if n=3
3 is odd: 3*3+1=10
10 is even: 10/2=5
5 is odd: 3*5+1=16
16 is even: 16/2=8
8 is even: 8/2=4
4 is even: 4/2=2
2 is even: 2/2=1
we reached 1 so the algorithm stops here.
Note: we also have to print the output of each step in a single line.

One question which might come to mind is that is it possible to reach 1 with any number. The ans is yes cuz at some point n will become a number which can be represented as 2^x (just like how we came to 16)
*/
class WeirdAlgorithm01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //use long input as n can go more than 2^31
        long n = Long.parseLong(sc.nextLine());
        System.out.print(n + " ");
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n * 3;
                n += 1;
            }
            //we use print() instead of println as we want the answer in a single line
            System.out.print(n + " ");
        }
        sc.close();
    }
}

