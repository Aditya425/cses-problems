/*
https://www.youtube.com/watch?v=r21q_MOiMbo&list=PLcXpkI9A-RZLNzhkMB3SyNfagr1LzIGrp&index=2
https://cses.fi/problemset/task/1083

we're given a list of numbers from 1,2 to n but unordered and one of the number is missing. we've to find the missing number. Eg: 
5 (first input is the number of numbers)
2 3 1 5 (4 numbers will be given (n-1) where one number is missing)
here the answer is 4 as it's missing

easy way to solve this is by using the formula for the sum of 1 to n numbers which is (n*(n+1))/2. Then we take the sum of the given numbers and finally subtract this from the value we got from formula
sum of first 5 numbers using formula: (5*6)/2 = 15
sum of given numbers: 2+3+1+5=11
the missing number=15-11 = 4
*/

import java.util.*;

public class MissingNumber02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //while n itself is less than integer limit i.e n is upto 10^5 (integer limit is 10^10), the reason we use long instead of int is that when we do n*(n+1) then the result will be 10^10 and this intermediate result will be stored in int which will cause integer overflow. So we use long
        long n = sc.nextLong();
        long sum = 0;
        //input the (n-1) integers
        for (int i = 0; i < n - 1; i++) {
            long num = sc.nextLong();
            //while we're inputting also take sum
            sum = sum + num;
        }
        //formula value - sum of (n-1)
        long ans = (n * (n + 1) / 2) - sum;
        System.out.println(ans);
        sc.close();
    }
}
