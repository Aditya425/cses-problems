/*
https://cses.fi/problemset/task/1070
we're given an integer n. we've to arrange the numbers 1 to n in such a way that the absolutedifference between adjacent elements is not equat to 1 (we've to output the arrangement). If such an arrangement is not possible then output "NO SOLUTION". Eg:
n=5
ans=2 4 1 3 5
explanation: we can see that the absolute subtraction of any adjacent elements doesn't give 1:
abs(4-2)=2, abs(2-5)=-3, abs(5-3)=2, abs(3-1)=2

n=3
ans=NO SOLUTION
such an arrangement is not possible: 1 3 2 (3-2=1), 1 2 3 (abs(1-2)=1), 2 1 3 (abs(2-1)=1). So we print NOT POSSIBLE.

We can solve this by putting all the even numbers b/w 1 to n first and then putting all the odd numbers. This works cuz abs(even-even) != 1 and abs(odd-odd) != 1. You can see that we did the same thing in the example.

No solution case: this case happens when n <= 3 (as seen in above eg). it is possible to arrange  when n >= 4.
*/

import java.util.*;

public class Permutations05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //is n is 1 then we arrange it as 1 (there is no other number to subtract it from)
        if (n == 1) {
            System.out.println(1);
        } else if (n <= 3) {
            System.out.println("NO SOLUTION");
        } else {
            //we'll use stringbuilder to build the strings. If we use string concatentation then it'll lead to memory wastage
            StringBuilder sb = new StringBuilder();
            //append even numbers from 1-n
            for (int i = 2; i <= n; i+=2) {
                //also append space at the end
                sb.append(i).append(" ");
            }
            //then append odd numbers
            for (int i = 1; i <= n; i+=2) {
                sb.append(i).append(" ");
            }
            //before printing ans we need to remove the extra space that was included after appending all the odd numbers
            System.out.println(sb.toString().trim());
            sc.close();
        }

    }
}
