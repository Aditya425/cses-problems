/*
https://cses.fi/problemset/task/1755

We're given a string of letters. Our task is to reorder the letters in such a way that resulting string becomes a palindrome.
Input:
string consisting of letters
Output:
The palindromic string. If this can't be done then print "NO SOLUTION"

Eg:
Input:
AAAACACBA
Output:
AACABACAA

a palindrome is always made of equal sets of letters. If a letter appears on one side of the string then the letter should appear again. Eg: abba is a palindrome cuz it has even a's and even b's.
to rearrange a string to make a palindrome, there are 2 cases:
1. if the string length is even: every letter must appear even number of times
2. if the string length is odd: one letter can appear odd number of times, other letters must appear even number of times.
If the string doesn't follow above rules then print "NO SOLUTION"

To check if it can be converted to palindrome, we need to count frequency of each letter and make sure that every letter appears even number of times and odd letters should appear only one time.

To build the palindrome, we follow this logic: since a letter is appearing 2 times, we put the letter to the left side first. To build the right side, just reverse the left side and appeand it to left side.

Eg: consider "aaabbbb"
first we build the frequency array which is an int array of size 26. Here each index corresponds to each letter (0 => A, 1 => B ... 25 => Z). In this case the array will be [3,4,0,0,...0]. Then check if all letters have even frequency. If there is an odd frequency then there should be only 1 letter like that. Our case passes both these conditions. Now we build the left half of the palindrome. The left half will contain 2 b's (4/2=2) and 1 a (3/2=1) it will be arranged chronologically. Consider a string which holds our left half, say lefthalf. So lefthalf="abb". We append this to our result string, say palin. palin.append(lefthalf), palin="abb"
Now we check if we've any odd freq letters which we've. We append that to the middle. palin.append("a"), palin="abba"
Now we append the right half. The right half is equal to reverse of left half (because in palindrome, lefthalf == reverse of righthalf). hence we do palin.append(lefthalf.reverse()), palin += "bba". palin="abba"
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PalindromeReorder12 {
    public static void main(String[] args) throws IOException {
        // buffered reader is a class that reads text buffering the characters into
        // memory at once rather than parsing every character individually (like how
        // scanner does)
        // isr is a bridge from byte streams to character streams. It reads bytes
        // (understood by computers) and decodes them to characters. System.in is the
        // source for the bytes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if (s == null || s.isEmpty())
            return;
        // count frequencies of each character A-Z
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'A']++;
        }

        // Step 2: Check for validity (at most one odd frequency allowed)
        int oddCount = 0;
        char oddChar = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                oddChar = (char) ('A' + i);
            }
            if (oddCount > 1) {
                System.out.println("NO SOLUTION");
                return;
            }
        }

        /*
         * "aaabbbb"
         * count = [3,4,0,0...]
         * leftHalf="abb"
         * i=0
         * j=0,true
         * j=1,false
         * i=1
         * j=0,true
         * j=1,true
         * j=2,false
         */
        // Step 3: construct the left half of the palindrome
        StringBuilder leftHalf = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            // take exactly half of the occurences, into the left side
            for (int j = 0; j < count[i] / 2; j++) {
                leftHalf.append((char) ('A' + i));
            }
        }

        // Step 4: Assemble final palindrome
        StringBuilder palindrome = new StringBuilder();
        palindrome.append(leftHalf);
        if (oddCount == 1) {
            // append central letter if it exists
            palindrome.append(oddChar);
        }

        // append mirrored left half
        palindrome.append(leftHalf.reverse());

        System.out.println(palindrome.toString());
    }
}
