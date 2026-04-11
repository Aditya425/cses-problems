/*
https://cses.fi/problemset/task/1618

we're given a number n, we've to output the number of trailing zeroes when we do n!.
Eg: if we take n=20 then 20!=2432902008176640000. We output 4 as it has 4 trailing zeros.
Input:
n
Output:
<no of trailing zeros in n!>

finding number of trailing zeros in a number:
consider 100. The way we can count the trailing zeros is by counting how many times it is divisible by 10. 100/10 = 10, since 100 was divided wkt that there is 1 trailing zero
10/10=1 Now we divide again with last step ans. Since division was possible, there are 2 trailing zeros
1/10. Here division is not possible so we stop. There are total 2 trailing zeros

One way to solve this is by finding the factorial and then applying the above logic. However this is very time consuming.

WKT n!=1x2x3...x(n-1)xn
Here it means that whenever 10 and its multiples are multiplied, then a zero is added. In other words we can say that whenever the numbers 2 and 5 appear (cuz 2x5=10) then a multiple of 10 will appear which means that 0 is added.
multiple of 10 = (2*a) * (5*b) ie a multiple of 10 is created whenever anything along with 2 and 5 is multiplied.
Now are our task is basically counting the number of times 2 (and its multiples like 4,6,8...) and 5 (and its multiples like 10,15,20...) appear in the factorial. Here we've to remember that for every pair of (2,5) and its multiples, a 10 is created, hence a trailing zero is created.
For eg: consider 10!=1x2x3x4x5x6x7x8x9x10
number of multiples of 2 is given by 10/2 ie 5 which are 2,4,6,8,10. Dividing the number 'a' by 'b' gives equal parts of 'b' which is obviously the total multiples present
Similarly number of multiples of 5 is 10/5 ie 2 which is 5,10.
So the pair of numbers which create a 10 are (2,5) and (4,10) so the number of trailing zeros in 10! is 2. 

We come to an important understanding that number of multiples of 5 will always be lower than number of multiples of 2 in a factorial. This is because 5 > 2. In other words, for every multiple of 5 there is guranteed to be a matching pair of multiple of 2. So we can conclude that instead of finding multiples of both 2 and 5 and then matching them, we can just count the number of multiples of 5 and that will be our answer.

Eg 2: 25
wkt 25=25x24x23...1
number of multiples of 5 = 5,10,15,20,25 = 5
But is the answer 5, no the ans is 6. This is because of 25. 25=5x5, so we've two 5's.
5=5x1 (no of 5's=1)
10=5x2 (no of 5's=2)
15=5x3 (no of 5's=3)
20=5x4 (no of 5's=4)
25=5x5 (no of 5's=4+2=6)
In other way, here we basically calculate the number of multiple of 5's and number of 25's ie, number of 5's=25/5 which is 5. Also calculate number of multiple of 25 (to calculate the extra 5) = 25/25 = 1. Total multiple of 5's = number of multiple of 5's + number of multiple of 25 = 5+1 = 6
The reason we're doing this is because 25 is contributing two 5's whereas others are contributing one 5.
This is true for all 5^k.

So our problem now becomes dividing our input n by 5^k (where k starts from 1) provided 5^k is less than n. Mathematically we can represent it like this:
the ans to this prb = sum of n/(5^k)  = n/5 + n/25 + n/125 until (5^k) < n or 
keep dividing n by 5 until n >= 5. This works cuz for 1st division it is n/5, when we divide by 5 again it becomes (n/5)/5 which is n/25
*/

import java.util.*;

public class TrailingZeroes10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        //the count which holds the number of zeros ie it holds the results of n/5 + n/25 etc..
        int count = 0;
        //divide n until it is divisible by 5 ie for this to happen, n should be >= 5
        while (n >= 5) {
            n = n / 5;
            //add the result of n after division of 5, which is the number of zeros
            count += n;
        }
        System.out.println(count);
    }
}
