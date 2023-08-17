// Next Smallest Palindrome
// Given a number, in the form of an array Num[] of size N containing digits from 1 to 9(inclusive). The task is to find the next smallest palindrome strictly larger than the given number.

// Example 1:

// Input:
// N = 11
// Num[] = {9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2}
// Output: 9 4 1 8 8 0 8 8 1 4 9
// Explanation: Next smallest palindrome is
// 94188088149.



package cal.acc;

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
 // Driver code
 public static void main(String[] args) throws Exception {
     BufferedReader br =
         new BufferedReader(new InputStreamReader(System.in));
     int t = Integer.parseInt(br.readLine().trim());
     while (t-- > 0) {
         int n = Integer.parseInt(br.readLine().trim());
         int num[] = new int[n];
         String[] str = br.readLine().trim().split(" ");
         for (int i = 0; i < n; i++) {
             num[i] = Integer.parseInt(str[i]);
         }

         Vector<Integer> ans = new Solution().generateNextPalindrome(num, n);
         for (Integer x : ans) {
             System.out.print(x + " ");
         }
         System.out.println();
     }
 }
}
//} Driver Code Ends


class Solution {

 Vector<Integer> generateNextPalindrome(int num[], int n) {
     int inc = 1;
     int i = 0;
     int j = n - 1;

     boolean allNine = true;
     for (int k = 0; k < n; k++) {
         if (num[k] != 9) {
             allNine = false;
             break;
         }
     }

     if (allNine) {
         Vector<Integer> a = new Vector<>();
         for (int k = 0; k <= n; k++) {
             a.add(0);
         }
         a.set(n, 1);
         a.set(0, 1);
         return a;
     }

     while (i < j) {
         if (num[i] != num[j]) {
             if (num[j] < num[i]) {
                 inc = 0;
             } else {
                 inc = 1;
             }

             num[j] = num[i];
         }
         i++;
         j--;
     }

     if (inc == 1) {
         if (i == j) {
             num[i]++;
             if (num[i] >= 10) {
                 num[i] = 0;
                 j = i + 1;
                 i--;
                 int prev = 1;
                 while (i >= 0 && prev != 0) {
                     num[i]++;
                     prev = num[i] / 10;
                     num[i] %= 10;
                     num[j++] = num[i--];
                 }
             }
         } else {
             num[i]++;
             num[j]++;
             if (num[i] >= 10) {
                 num[i] = 0;
                 num[j] = 0;
                 int temp = i;
                 i = j;
                 j = temp;
                 i--;
                 j++;

                 int prev = 1;
                 while (i >= 0 && prev != 0) {
                     num[i]++;
                     prev = num[i] / 10;
                     num[i] %= 10;
                     num[j++] = num[i--];
                 }
             }
         }
     }

     Vector<Integer> result = new Vector<>();
     for (int k = 0; k < n; k++) {
         result.add(num[k]);
     }
     return result;
 }
}
