package gkgpotd;
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class PalindromeString {
  public static void main(String args[]) throws IOException {
      BufferedReader read =
          new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(read.readLine());
      while (t-- > 0) {
          String S = read.readLine();
          
          SolutionPalindrome ob = new SolutionPalindrome();
          System.out.println(ob.isPalindrome(S));
      }
  }
}
//} Driver Code Ends


//User function Template for Java
class SolutionPalindrome {
  int isPalindrome(String S) {
      // Convert the string to lowercase to make the comparison case-insensitive
      S = S.toLowerCase();

      int left = 0;
      int right = S.length() - 1;

      while (left < right) {
          // Ignore non-alphanumeric characters from the left
          while (left < right && !Character.isLetterOrDigit(S.charAt(left))) {
              left++;
          }
          // Ignore non-alphanumeric characters from the right
          while (left < right && !Character.isLetterOrDigit(S.charAt(right))) {
              right--;
          }

          // Compare characters
          if (S.charAt(left) != S.charAt(right)) {
              return 0; // Not a palindrome
          }

          left++;
          right--;
      }

      return 1; // Palindrome
  }
}
