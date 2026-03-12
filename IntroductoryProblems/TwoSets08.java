/*
https://cses.fi/problemset/task/1092

we're given a number n. Consider 1,2...n. Our first task is to check whether the set of numbers from 1 to n can be divided into 2 parts whose sum is equal (the size of the parts may or may not be equal). Our 2nd task is to output those parts.
Eg input:
7 (n)
Eg output:
YES (print YES if we can do the first task else print NO. This means we can divide 1,2,3,4,5,6,7 into 2 arrays where sum of array1=sum of array2)
4 (print size of array1)
1 2 4 7 (array1)
3 (size of array2)
3 5 6 (array2)

Eg input:
6 (n)
Eg output:
NO (we cant do 1st task using 6 hence print NO and the program stops here.)

The idea behind this problem is that we've to sum up all the numbers from 1 to n. If sum is odd then it is not possible to separate 1 to n in 2 parts where sum of each part is equal (reason given below). If the sum is even then it's possible.

The sum of numbers from 1 to n is given by (n(n+1))/2

The 4 rule:
before continuing the problem, we can observe this pattern for 4 consecutive numbers. Consider a,a+1,a+2,a+3 then we can divide them into 2 parts which have equal sum:
a + a+3 = a+1 + a+2
For eg if we consider 1,2,3,4 then 1+4=2+3.
This works for numbers which are divisible by 4. If we consider 1,2,3,4,5,6,7,8. Do the above thing for 1st set of 4 numbers and then repeat it for next set of 4 numbers:
1+4=2+3 (for 1,2,3,4)
5+8=6+7 (for 5,6,7,8)
This means that if we want to split a number (1 to n) into lists whose sum is same then we first need to check if the number can be divided in 4 equal parts (ie number%4=0).

What if number%4 != 0 but the sum is even?
Consider 1,2,3. We see that 1+2=3
This means that if number%4!=0 then also we can split it in 2 parts whose sum is equal. Consider 1,2,3,4,5,6,7
set1={1,2} set2={3} (for 1,2,3)
set1={1,2,4,7} set2={3,5,6} (for 4,5,6,7)
we can see that sum of set1=sum of set2

How do we apply to this prb?
first we take the sum of 1 to n. This can be found out by doing (n(n+1))/2
if sum is odd then we print NO and the program exits
If sum is even then we see if number%4==0. If true then we do the separating process (as shown below "The 4 rule")
if number%4==1 then first separate numbers 1,2 in one list and 3 in other (as shown in eg above) and then continue with the separating process (as shown below "The 4 rule")

Is there a case where the sum is even but we can't divide it in 4 parts?
No, cuz the sum being equal ensures that the it can be split into 2 equal halves and it also means that the sum of both parts would be equal provided we exchange the numbers from one part to other. The 4 rule provides us a way to construct the parts where sum of the parts will be equal to each other.
*/

import java.io.PrintWriter;
import java.util.*;

public class TwoSets08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //use long as we're doing n*n where n can be 10^6
        long n = sc.nextLong();
        sc.close();
        //take the sum from 1 to n
        long sum = n * (n + 1) / 2;
        //if the sum is odd then we can't split them hence print NO
        if (sum % 2 != 0) {
            System.out.println("NO");
            return;
        } 
        //if sum is even then there is always a way to split so print yes
        //the string which contains the numbers present in the first list. We use stringbuilder instead of a list to improve time as we need not loop when printing the string.
        //first and second lists represented by string builder
        StringBuilder set1 = new StringBuilder();
        StringBuilder set2 = new StringBuilder();
        //the count of numbers contained in set1 and set2 resp. This can be int as the count will be less than 10^6
        int c1 = 0;
        int c2 = 0;
        //if n%4=0 then use the 4 rule
        if (n%4 == 0) {
            //we do this: go to the 1st set of 4 numbers and use the 4 rule and then jump to the next set of 4 numbers
            //for eg: this for loop generates i=1,5,9... until n and for each i we apply the 4 rule to get the numbers
            for (int i = 1; i <= n; i+=4) {
                //according to the rule a + a+3=a+1 + a+2. Here i is nothing but a
                //put a and a+3 in set1, Also append spaces so that we get an output like this: 1 4 ...
                set1.append(i).append(" ").append(i+3).append(" ");
                //since we added 2 numbers in set1 increase c1 by 2
                c1 += 2;
                //do same for set 2 ie add a+1 and a+2
                set2.append(i+1).append(" ").append(i+2).append(" ");
                c2 += 2;
            }
        } else {
            //if its not divisible by 4 then first separate 1,2,3 equally. 1,2 in set1 and 3 in set2
            set1.append("1 2 ");
            set2.append("3 ");
            //increase the counts of c1 and c2 to match size of set1 and set2 resp.
            c1=2;
            c2=1;
            //then apply the 4 rule. Start i from 4 as we already have 1 2 3
            for (int i = 4; i <= n; i+=4) {
                set1.append(i).append(" ").append(i+3).append(" ");
                set2.append(i+1).append(" ").append(i+2).append(" ");
                c1 += 2;
                c2 += 2;
            }
        }
        //printing output
        PrintWriter out = new PrintWriter(System.out);
        out.println("YES");
        out.println(c1);
        out.println(set1.toString().trim());
        out.println(c2);
        out.println(set2.toString().trim());
        out.flush();
    }
}
