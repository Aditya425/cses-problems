/*
https://cses.fi/problemset/task/2205
We've to calculate gray code.
Input: n=2
Output:
00
01
11
10

Gray code formula i ^ (i >> 1)
To understand why the formula gray = i ^ (i >> 1) works, we need to look at what happens when you count normally in binary versus what a Gray code needs.
The Problem with Normal Binary Counting
When you count up in standard binary, you often have to flip multiple bits at the same time.
- Going from 011 (3) to 100 (4) requires flipping all three bits simultaneously.
- In a Gray code, adjacent numbers are only allowed to change one bit at a time.

## Breaking Down the Formula: i ^ (i >> 1)
The formula uses two operations:
- i >> 1: Shifts the binary digits of $i$ one position to the right (dropping the last bit).
- ^ (XOR): Compares two bits. If the bits are different, it outputs 1. If they are the same, it outputs 0.Essentially, this formula compares each bit of $i$ with its neighbor to the left. If they differ, the Gray code has a 1 at that position; if they are the same, it has a 0.

For eg: n=2

Start from 00
i = 00
i >> 1 = 00 (shifted right)
00 ^ 00 = 00 (Gray code: 00)

Step 2:
i = 01
i >> 1 = 00
i ^ 00 = 01 ^ 00 = 01

Step 3:
i = 10
i >> 1 = 01
10 ^ 01 = 11
*/

import java.io.*;

public class GrayCode13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        int n = Integer.parseInt(line.trim());
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        
        // for an input 'n' there is going to be 2^n gray codes
        int total = 1 << n;
        for (int i = 0; i < total; i++) {
            int gray = i ^ (i >> 1);
            //gray is currently an int, convert it to binary string
            out.println(toBinaryString(gray, n));
        }
        out.flush();
    }

    //helper function which converts int to binary string
    private static String toBinaryString(int val, int n) {
        char[] buf = new char[n];
        //iterate from (n-1) which is rightmost part of buf cuz we need to build the string from unit place
        for (int i = n - 1; i >= 0; i--) {
            //and'ing with 1 gives us the binary digit from the unit place. 1&0=0, 1&1=1
            buf[i] = (val & 1) == 1 ? '1' : '0';
            //right shift to bring the digit at 10th place to unit place so that we can convert it to binary digit in the next loop
            val >>= 1;
        }
        return new String(buf);
    }
}
