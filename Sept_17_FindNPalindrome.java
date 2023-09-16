package gkgpotd;
//{ Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG17 {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    //taking total number of elements
		    int n=sc.nextInt();
		    
		    //calling printFibb() method
		    long[] res = new Solution().printFibb(n);
		    
		    //printing the elements of the array
		    for (int i = 0; i < res.length; i++)
		        System.out.print (res[i]+" ");
		    System.out.println();
		}
	}
}
//} Driver Code Ends


//User function Template for Java
class Sept_17_FindNPalindrome {
  // Function to return a list containing the first n Fibonacci numbers.
  public static long[] printFibb(int n) {
      // Create an array to store the Fibonacci numbers.
      long[] fibArray = new long[n];
      
      // Handle the base cases (n = 1 and n = 2).
      if (n >= 1) {
          fibArray[0] = 1; // First Fibonacci number
      }
      if (n >= 2) {
          fibArray[1] = 1; // Second Fibonacci number
      }
      
      // Calculate the Fibonacci numbers for n > 2.
      for (int i = 2; i < n; i++) {
          fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
      }
      
      return fibArray;
  }
}
