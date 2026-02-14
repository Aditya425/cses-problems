/*
https://cses.fi/problemset/task/1071

we're given a matrix of size 10^9 x 10^9 numbers and they follow a pattern. Here are the 1st 5 layers:
1  2  9  10 25
4  3  8  11 24
5  6  7  12 23
16 15 14 13 22
17 18 19 20 21
.....

the numbers follow a pattern. 1-2-3-4-5-6 goes in a zig zag way i.e (0,0),(0,1),(1,0),(1,1)...(2,1)
Now for 7-8-9-10-11-12 we go from bottom to top to bottom again.

Layer: we can observe that for: 
a. 1 (0,0) that there is no direction change.
b. 2 (0,1) the direction changes from left-right. We also see that 2-3-4 form a inverted 'L' shape
c. 5 (2,0) - 6 (2,1) - 7 (2,2) - 8 (1,2) - 9 (0,2) also form an inverted 'L' shape. Also observe that max(r,c) this time is 2 (for point b it was 1)
d. 10-11-12-13-14-15-16 from (0,3) to (3,0) also form an inverted 'L' shape but this time the max(r,c) from (0,3) to (3,0) is 3.

each of the inverted 'L' shapes is called layer.

Pattern: the pattern is an inverted 'L' shape which goes throughout the matrix. For eg: 1 (is the starting point so it doesn't form inverted 'L') then we've 2,3,4 which is another inverted 'L' and also notice that it goes from 2 (0,1) to 4 (1,0) and the max of (r,c) here is 1 (we call it layer 1), another thing is that the smallest number 2 starts at (0,1). Next we've 5,6,7,8,9 which go from 5 (2,0) to 9 (0,2) and max(r,c) is 2 (layer 2) and this time the smallest number is from (2,0). This goes on

What are we supposed to do?
we're basically given a (r,c) and we've to find the number at that position in the matrix. This is how input looks:
first line: number of test cases (n)
next lines: n lines of (r,c)
Eg:
3
2 3
1 1
4 2

we need to output matrix[2][3], matrix[1][1] and matrix[4][2].

How to solve this?
Simple way is to build the matrix however the matrix is of size 10^9 x 10^9 which means we need to store quadrillion numbers which is impossible.
Consider coordinates as (x,y)
find the layer which is max(x,y). Consider it as M, now there can be 2 cases:
    1. M is even: then it means that number increase as we go left in the inverted 'L' (see row 2 in the eg above). There are 2 cases:
        a. x == M: then the ans is (M * M) - y + 1
        b. x != M: then the ans is ((M-1)*(M-1))+x
    2. M is odd: then it means number decreases as we go left in the inverted 'L' (see row 3 in the eg above). There are 2 cases:
        a. y == M: ans=(M * M) - x + 1
        b. y != M: ans=((M-1)*(M-1))+y
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class NumberSpiral06 {
    //Here we need to read the input fast. Scanner cannot be used as scanner typically read a input from the console and then parses it (based on type of input like int, long etc) and then saves it in memory and then does the same for the next input whereas BufferedReader reads an entire line and saves it in memory. Scanner uses regular expressions to separate the input on the same line (it separates based on spaces on the same line) and then saves it to memory whereas BufferedReader doesn't do any kind processing and directly saves the whole line to memory
    //Since BufferedReader reads the whole line, we use StringTokenizer to convert the line into tokens (individual strings)
    //to combine both BR and ST we use a custom class called FastReader
    static class FastReader {
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
        FastReader fr = new FastReader();
        //we use PrintWriter instead of System.out.println as PrintWriter collects the result in memory and then prints it (whenever we do print) whereas System.out.println prints the result immediately
        PrintWriter out = new PrintWriter(System.out);

        int tc = fr.nextInt();

        //until test cases reach 0, we go on doing this operation. For eg: tc=3 then while will run for 3,2,1 and when tc is 0 it'll exit
        while (tc-- > 0) {
            //technically 10^10 is the limit for int however we still use long for x and y (even though they are 10^9) as we'll add x and y to m
            long x = fr.nextLong();
            long y = fr.nextLong();
            long m = Math.max(x, y);
            long ans;
            if (m % 2 == 0) {
                //even
                if (x == m)
                    ans = (m*m) - y + 1;
                else
                    ans = ((m-1)*(m-1))+x;
            } else {
                //odd
                if (y == m)
                    ans = (m*m) - x + 1;
                else
                    ans = ((m-1)*(m-1))+y;
            }
            //collect the ans but don't print it. Also we use println to add space between each output
            out.println(ans);
        }
        //print all the ans onto console
        out.flush();
        //close output stream
        out.close();
    }
}
