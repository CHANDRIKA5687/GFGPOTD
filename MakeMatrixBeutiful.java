package gkgpotd;
//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
  public static int[][] input(BufferedReader br, int n, int m) throws IOException
  {
      int[][] mat = new int[n][];

      for(int i = 0; i < n; i++)
      {
          String[] s = br.readLine().trim().split(" ");
          mat[i] = new int[s.length];
          for(int j = 0; j < s.length; j++)
              mat[i][j] = Integer.parseInt(s[j]);
      }

      return mat;
  }

  public static void print(int[][] m)
  {
      for(var a : m)
      {
          for(int e : a)
              System.out.print(e + " ");
          System.out.println();
      }
  }

  public static void print(ArrayList<ArrayList<Integer>> m)
  {
      for(var a : m)
      {
          for(int e : a)
              System.out.print(e + " ");
          System.out.println();
      }
  }
}

class GFG {
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t;
      t = Integer.parseInt(br.readLine());
      while(t-- > 0){
          
          int N;
          N = Integer.parseInt(br.readLine());
          
          
          int[][] matrix = IntMatrix.input(br, N, N);
          
          Solution obj = new Solution();
          int res = obj.findMinOperation(N, matrix);
          
          System.out.println(res);
          
      }
  }
}

//} Driver Code Ends

class Solution {

  static int findMinOperation(int N, int matrix[][]) {
      // Initialize the sumRow[] and sumCol[] array to 0
      int[] sumRow = new int[N];
      int[] sumCol = new int[N];
      // Calculate sumRow[] and sumCol[] array
      for (int i = 0; i < N; ++i)
          for (int j = 0; j < N; ++j) {
              sumRow[i] += matrix[i][j];
              sumCol[j] += matrix[i][j];
          }
      // Find maximum sum value in either row or in column
      int maxSum = 0;
      for (int i = 0; i < N; ++i) {
          maxSum = Math.max(maxSum, sumRow[i]);
          maxSum = Math.max(maxSum, sumCol[i]);
      }
      int count = 0;
      for (int i = 0, j = 0; i < N && j < N;) {
      
          int diff = Math.min(maxSum - sumRow[i], maxSum - sumCol[j]);
          matrix[i][j] += diff;
          sumRow[i] += diff;
          sumCol[j] += diff;
         
          count += diff;
           if (sumRow[i] == maxSum)
              ++i;
          // If jth column satisfied, increment jth value
          // for next iteration
          if (sumCol[j] == maxSum)
              ++j;
      }
      return count;
  }
}