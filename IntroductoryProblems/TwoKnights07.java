/*
https://cses.fi/problemset/task/1072

We've to consider knights (horse which does 'L' movement) on a chessboard. We're given an input 'n'. Our job is to determine the number of ways in which 2 knights can be placed on a k x k chessboard where k=1,2,...n where the knights do not attack each other. Note that we should do this for all numbers i.e from k=1 to n
Eg input:
8 (n)
Output:
0 (number of ways where 2 knights can be placed without attacking each other in a 1x1 chessboard)
6 (number of ways where 2 knights can be placed without attacking each other in a 2x2 chessboard)
28 (number of ways where 2 knights can be placed without attacking each other in a 3x3 chessboard)
96 (number of ways where 2 knights can be placed without attacking each other in a 4x4 chessboard)
252 (number of ways where 2 knights can be placed without attacking each other in a 5x5 chessboard)
550 (number of ways where 2 knights can be placed without attacking each other in a 6x6 chessboard)
1056 (number of ways where 2 knights can be placed without attacking each other in a 7x7 chessboard)
1848 (number of ways where 2 knights can be placed without attacking each other in a 8x8 chessboard)

Instead of calculating number of ways they cant attack each other, we can calculate the number of ways in which they can attack each other and subtract this from total number of ways in which 2 knights can be placed on the board. ie Number of ways in which 2 knights dont attack each other in a kxk board = Total ways we can place 2 knights on kxk board - number of ways in which 2 knights attack each other on a kxk board. We apply this formula for k=1 to n

Total ways we can place 2 knights on kxk board:
We've to use the combinations (because the order in which we pick the squares on the board doesnt matter) formula ie the ncr formula
Total number of squares = kxk = k^2 = n
Number of ways to select the place for the 1st knight = k^2c1
Explanation: here r=1 as we've to select one position from k^2 pos. k^2c1 can be written as k^2 after solving (as nc1 = n)
Number of ways to select the place for the 2nd knight = (k^2-1)c1
Explanation: since we've already selected a position for 1st knight, the remaining positions are k^2-1 hence it becomes our new n. r=1 as we've to select a single position. This can be written as k^2-1
Total no. of ways = Number of ways to select the place for the 1st knight x Number of ways to select the place for the 2nd knight = k^2 * (k^2 - 1)

The above formula treats knight1 and knight2 as different. For eg: according to what we've calculated above (k^2 * (k^2 - 1)), placing k1 on 1x1 square and k2 on 2x2 square is different than placing k1 on 2x2 square and k2 on 1x1 square. This is incorrect as both are same according to the problem.
To fix this, we've to divide it by 2. The formula takes into account both the cases (k1 on x pos and k2 on y pos same as vice versa), we need to take into account only the 1st case (k1 on x pos and k2 on y pos are same) which is why we divide by 2.
So the formula is (k^2 * (k^2 - 1))/2

How 2 knights attack each other:
knights always attack in an 'L' fashion. i.e:
current position (k means knight and . means empty position on a chessboard): k . .
                                                                                  .
After moving: . . .
                  k
you can see that the way it moves forms an 'L'. Here we're only representing from left to right. This also happens from top-bottom, bottom-top and right-left. Basically a knight moves 2 squares in one direction and then moves one square perpendicular to the prev square.
If we consider 2x3 rectangle, a knight when placed in 1x1 will go to 2x3 position.
if knight k1 is at 1x1 and knight k2 is at 2x3 then they can attack each other. Similarly if k1 is at 1x3 and k2 is at 2x1 then they attack each other. This means there are 2 ways in a 2x3 rectangle where 2 knights are in an attacking position. Those 2 positions are present diagonally ie 1st pos is (1x1) and (2x3) which is diagonal d1, the 2nd pos is (1x3) and (2x1) which is diagonal d2.
We've calculated for left-right and right-left. Now we've to calculate for top-bottom and vice versa. To do this we consider 3x2 rectangle. The attacking positions here are (1x1), (3x2) (diagonal d1) and (1x2), (3x1) (diagonal d2)
Now that we found the attacking positions, we now need to find how many 2x3 and 3x2 rectangles can fit on a kxk board (for all k=1 to n). If we do this then we basically find the number of ways in which 2 knights can attack each other on all kxk boards.
2x3:
    there are 2 ways we can put 2x3 in a kxk board, either side-by-side (horizontally) or stack (vertically) and we've to calculate for both
    vertical: in a kxk board we can fit (k-1) of them. How? consider k=3, then 
    . . .
    . . .
    . . .
    you can see that the first 2x3 goes on rows 1 and 2 and the second 2x3 goes on rows 2 and 3. Similarly for k=4, we can 2x3 in rows 1-2,2-3,3-4. Hence we can fit (k-1) 2x3's in a kxk board
    horizontal: consider k=4
    . . . .
    . . . .
    . . . .
    . . . .
    we can fit 1st 2x3 in col 1, 2nd 2x3 in col 2. So 4x4 we can fit two 2x3's. For kxk we can fit (k-2) 2x3's
    Total 2x3 blocks on a kxk board = no. of 2x3 in vertical * no. of 2x3 in horizontal = (k-1)(k-2)
    
    Number of attacking positions in one 2x3 = 2
    Total attacking positions when kxk board is divided into 2x3 = 2 * no. of vertical 2x3 * no. of horizontal 2x3 = 2(k-1)(k-2)

3x2:
    Like 2x3, we can put 3x2 vertically and horizontally
    vertical: we can fit (k-2) of them in a kxk board. The reason is same as horizontal of 2x3. For eg: If we keep stacking 3x2 on a 5x5 board then we can stack 3 of them.
    Horizontal: we can fit (k-1) of them in a kxk board. For eg: if we've an 4x4 board then we can place 3 3x2s horizontally.
    Total 3x2 blocks on a kxk board = no. of 2x3 in vertical * no. of 2x3 in horizontal = (k-2)(k-1)
    Number of attacking pos in one 3x2 = 2
    Total attacking positions when kxk board is divided into 3x2 = 2 * no. of vertical 3x2 * no. of horizontal 2x3 = 2(k-2)(k-1)

Total attacking positions on a kxk board = no. of attacking positions of 2x3 + no. of attacking positions of 3x2 = 2(k-1)(k-2) + 2(k-2)(k-1) = 4(k-1)(k-2)

Final formula:
it is (k^2 * (k^2 -1))/2 - 4(k-1)(k-2)
*/

import java.io.PrintWriter;
import java.util.*;

public class TwoKnights07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        PrintWriter out = new PrintWriter(System.out);

        for (long k = 1; k <= n; k++) {
            //total ways to pick 2 squares out of kxk squares
            //2x2x1/2 = 2
            long totalWays = (long) (k * k * (k * k - 1)) / 2;
            //no of ways 2 knights attack each other
            //4x1
            long attackWays = 4 * (k-1) * (k-2);
            //final ans
            out.println(totalWays - attackWays);
        }
        out.flush();
        out.close();
        sc.close();
    }
}
