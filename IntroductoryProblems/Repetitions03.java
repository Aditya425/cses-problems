/*
https://www.youtube.com/watch?v=Hkco6tZ6kU4&list=PLcXpkI9A-RZLNzhkMB3SyNfagr1LzIGrp&index=3
https://cses.fi/problemset/task/1069

we're given a string of characters consisting of letters "A", "C", "G" and "T" only. Our task is to find the length of the longest sequence where each character is same (or longest repeating sequence where sequence has same characters). Eg:
"ATTCGGGA"
ans=3 cuz "GGG" is the longest sequence where all the characters are the same. The string "TT" has the same letter but its length is only 2 hence is not our ans.

To solve this we first maintain a counter variable called c which maintains the length of the sequence with  same chars and a var called max which will have the max value of c. Then we start a loop through the string and 
2 things can happen:
1. while looping if we find current char and prev char are same then we increase our counter by 1. The we compare counter with max i.e if counter is > than max than make max=counter
2. if current and prev char are not same then a sequence cannot be made so reset counter to 1 as the longest sequence which can be made from here is 1 (and the sequence is the current char itself). Here we need not update max as counter is resetted
*/

import java.util.*;

public class Repetitions03 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		//the longest sequence of equal chars when no char is same is 1 so initialize with that
		int max = 1;
		int c = 1;

		for (int i = 1; i < s.length(); i++) {
			//cur and prev char is same so increment c by 1 and update value of max if required
			if (s.charAt(i - 1) == s.charAt(i)) {
				c++;
				max = Math.max(c, max);
			} else {
				//if curr and prev char are not same then the longest sequence where each char is same is 1 so make c equal to 1
				c = 1;
			}
		}

		System.out.println(max);
		sc.close();
	}
}
