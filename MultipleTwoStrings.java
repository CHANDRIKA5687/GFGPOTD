package gkgpotd;
//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;

class MultipleTwoStrings{
  public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      int t=sc.nextInt();
      while(t-->0){
          String a=sc.next();
          String b=sc.next();
          Solution1 g=new Solution1();
          System.out.println(g.multiplyStrings(a,b));
      }
  }
}
//} Driver Code Ends


class Solution1 {
  public String multiplyStrings(String s1, String s2) {
      boolean isNegative = false;
      
      // Check if one or both numbers are negative
      if (s1.charAt(0) == '-' && s2.charAt(0) == '-') {
          isNegative = false; // Two negatives make a positive
          s1 = s1.substring(1);
          s2 = s2.substring(1);
      } else if (s1.charAt(0) == '-') {
          isNegative = true;
          s1 = s1.substring(1);
      } else if (s2.charAt(0) == '-') {
          isNegative = true;
          s2 = s2.substring(1);
      }
      
      int m = s1.length();
      int n = s2.length();
      
      // Create an array to store the individual multiplication results
      int[] result = new int[m + n];
      
      // Multiply each digit of s1 with each digit of s2
      for (int i = m - 1; i >= 0; i--) {
          for (int j = n - 1; j >= 0; j--) {
              int digit1 = s1.charAt(i) - '0';
              int digit2 = s2.charAt(j) - '0';
              int product = digit1 * digit2;
              
              int sum = product + result[i + j + 1];
              result[i + j + 1] = sum % 10;
              result[i + j] += sum / 10;
          }
      }
      
      // Build the final result string
      StringBuilder sb = new StringBuilder();
      for (int digit : result) {
          sb.append(digit);
      }
      
      // Remove any leading zeros
      while (sb.length() > 0 && sb.charAt(0) == '0') {
          sb.deleteCharAt(0);
      }
      
      // If the result is zero, return "0"
      if (sb.length() == 0) {
          return "0";
      }
      
      // If the result is negative, prepend "-"
      if (isNegative) {
          sb.insert(0, '-');
      }
      
      return sb.toString();
  }
}