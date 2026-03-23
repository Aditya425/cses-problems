/*
https://cses.fi/problemset/task/1617/
we're given a number n as input. Our aim is to find how many binary strings (strings with 0 or 1) are possible with length n. Eg:
Input:
3 (n)
Output:
8

Explanation: with length 3, 8 binary strings are possible. The strings are 000,001,010,011,100,101,110,111.
we can imagine the prb like this. Since n=3, we've 3 empty spaces in our string i.e "---". In each space we've 2 choices ie we can either fill 0 or 1. Hence the final ans will 2^n.

An imp thing to remember here is that we've print the answer modulo 10^7. This is done to ensure that the answer doesn't get very large.

One imp thing is that we can't use the class Math.pow(base,exponent). This is cuz it would print out infinity once the number gets out of bounds. Consider n=10^6 (the limit of n in this problem), now if we do Math.pow(2,1000000) then it would print out "Infinity". This is cuz Math.pow returns a double and the limit of double is 10^308 and 10^308 < 2^10^6. Another reason is that we've to apply 10^7 modulo on every step of the exponentiation and we cant do that with Math.pow() as we get the whole ans first and then do the modulo.
*/

import java.util.*;

public class BitStrings09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        //mod can be int as int limit is 10^10
        int mod = 1000000007;
        //result can be int as the limit of int is 10^10 and the mod value is 10^7 which means that result cant exceed 10^7
        int result = 1;
        //write a for loop
        for (int i = 0; i < n; i++) {
            result = (result * 2) % mod;
        }
        System.out.println(result);
    }
}
