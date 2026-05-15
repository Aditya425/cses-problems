/*
https://cses.fi/problemset/task/1754

we're given 2 piles of coins. Our goal is to remove the coins from each of the stack and at the end finish it. While removing we've to follow this condition: you can either remove one coin from the left pile and two coins from the right pile OR remove two coins from the left pile and 1 coin from the right pile.
Our task is to find out if we can empty both the piles or not

Input:
the first line contains the number of test cases, t
Next there are t lines. Each line has 2 integers a and b which are the left and right piles

Output:
for each test, print YES if you can empty the piles and NO if you can't

Eg:
3 (t) (3 lines are there next)
2 1 (a b)
2 2
3 3

Basically in every move, we remove 3 coins (either 1+2 or 2+1). Therefore this means (a+b) must be divisible by 3 . If they aren't then it means that some coins will remain. For eg: consider a=2,b=3. 
2 3 (originally)
0 2 (take 2 from a and 1 from b)
You can see that it is not possible to proceed further.

The second condition that it must fullfil is that a:b or b:a must be less than or equal to 2:1 or 1:1 ratio. In other words 'a' must be less than or equal to twice of b (if a < b) or b must be less than or equal to twice of 'a' (if b > a). In other words greater number must be <= 2 x smaller number. This is because we take 2 coins from one and 1 coin from other. To finish both of them they must be in that ratio (or less than it).

For eg: 
6 3
4 2 (-2,-1)
2 1 (-2,-1)
0 0
The above prb was solved only because 3x2 was <= 6. If we consider 1:1 ratio, then take 6,6
6,6
4,5
3,3
2,1
0,0

Consider a eg where a < 2b. Consider (5,4)
5,4
3,3
1,2
0,0

Now consider a,b where (a+b) is divisible by 3 but they're not in 2:1 or 1:1 ratio
9,3
7,2
5,1
3,0
you can see that we can't proceed further. If we analyze it, we can see that 9,3 can be solved when we reduce one by 3 and other by 1:
9,3
6,2
3,1
0,0
Basically (a,b) should be in the ratio (or less than it) in the way we want to reduce it.

To conclude we check for 2 cases:
1. a+b must be divisible by 3
2. a:b (or b:a, depends on if a>b or b>a) is in 2:1 ratio
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class CoinPiles11 {
    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        //initialize the buffered reader
        public FastReader() {
            //InputStreamReader forms a connection to the console (System.in) and then buffered reader can read from console
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        //this method joins both buffered reader and string tokenizer.
        String next() {
            //this while runs until string tokenizer reads all the words in a single line. We use a while loop so that we can read multiple lines
            //st is null when we run this code for the 1st time, so in that case we initialize st object with the current line
            //if st is at an input in the current line then this while wont run because st.hasMoreTokens is true. If st goes beyond the last input in the current line then then st.hasMoreTokens is false and then this code will run and it'll read the next line
            //for eg: consider this input:
            //1 2
            //3 4
            //first we'll initialize FastReader and create object of br. Then we'll call fr.nextInt() (from main) which in turn will call the next().
            //1st line: st is null so it goes inside the while loop. There we read the line "1 2" using br.readLine() anf then pass into constructor of st. When the while loop runs again both conditions will return false (st is not null and st.hasMoreTokens() is true). We come out of while loop and return "st.nextToken()" which returns 1 (as 1 is the 1st input)
            //1st line: Now we come to this method again (we call nextInt() in main which in turn calls next()). while loop wont run cuz both conditions are false. then this method returns "2" (by running st.nextToken())
            //2nd line: Now we come to this method again. 1st condition is false but 2nd condition is true (st.hasMoreTokens() is false as there are no more chars after 2). So we come inside the loop and read the 2nd line (by executing br.readLine()). st will tokenize and this process will repeat
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        //used to read int inputs. next() will return the input as a string and parseInt will convert to int and return it. Same goes for nextLong()
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
    }
    public static void main(String[] args) {
        //use FastReader instead of Scanner as it gives TLE
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int tc = fr.nextInt();
        //until text cases become 0
        while (tc-- > 0) {
            //a and b are 10^9 which can come inside int but we're going to do 2*a or 2*b which can go above 10^10 hence we're choosing long
            long a = fr.nextLong();
            long b = fr.nextLong();
            //condition 1: a+b must be divisible by 3
            //condition 2: greater number <= 2*smaller number. We use max(a,b) and min(a,b) to find greater and smaller number resp.
            if ((a+b) % 3 == 0 && Math.max(a,b) <= 2 * Math.min(a,b)) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
        out.flush();
        out.close();
    }
}
