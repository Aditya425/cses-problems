/*
https://cses.fi/problemset/task/2165

The Tower of Hanoi game consists of three stacks (left, middle and right) and n round disks of different sizes. Initially, the left stack has all the disks, in increasing order of size from top to bottom.
The goal is to move all the disks to the right stack using the middle stack. On each move you can move the uppermost disk from a stack to another stack. In addition, it is not allowed to place a larger disk on a smaller disk.
Your task is to find a solution that minimizes the number of moves.

## Input
The only input line has an integer n: the number of disks.

## Output
First print an integer k: the minimum number of moves.
After this, print k lines that describe the moves. Each line has two integers a and b: you move a disk from stack a to stack b.

Example

Input:
2

D1
D2
A	B	C (where D2 > D1)

Output:
3
-> 1 2
D2	D1	
A	B	C

-> 1 3
	D1	D2
A	B	C

-> 2 3
		D1
		D2
A	B	C

Way to solve:
The Tower of Hanoi is a classic recursive problem. To move $n$ disks from a source stack to a target stack using an auxiliary stack:

1. Move the top $n-1$ disks from the source stack to the auxiliary stack.
2. Move the remaining largest disk directly from the source stack to the target stack.
3. Move the $n-1$ disks from the auxiliary stack to the target stack.

Minimum Number of Moves:
The minimum number of moves required for $n$ disks is given by:$$k = 2^n - 1$$


*/

import java.util.*;

public class TowerOfHanoi14 {
	/*
	1.	src=1
		dest=3
		aux=2
		n=2
		false
		print(1 + " " + 3)


	2.	src=1				2.	src=2
		dest=2					dest=3	
		aux=3					aux=1
		n=1						n=1
		print(1 + " " + 2)		print(2 + " " + 3)


	3.	src=1	3.	src=2	3.	src=1
		dest=3		dest=3		dest=3
		aux=2		aux=1		aux=2
		n=0			n=0			n=0

	Output:
	1 2
	1 3
	2 3
	*/
	public static void solve(int src, int dest, int aux, int n) {
		if (n <= 0) {
			return;
		}
		solve(src, aux, dest, n - 1);
		System.out.println(src + " " + dest);
		solve(aux, dest, src, n - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println((int)Math.pow(2, n) - 1);
		solve(1, 3, 2, n);
	}
}
