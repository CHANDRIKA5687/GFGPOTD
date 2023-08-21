package ninjaslayground;
//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
  public static void main(String[] args) throws IOException
  {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter out=new PrintWriter(System.out);
      int T = Integer.parseInt(br.readLine().trim());
      while(T-->0)
      {
          String[] s = br.readLine().trim().split(" ");
          int n = Integer.parseInt(s[0]);
          int m = Integer.parseInt(s[1]);
          int[][] matrix = new int[n][m];
          for(int i = 0; i < n; i++){
              String[] S = br.readLine().trim().split(" ");
              for(int j = 0; j < m; j++)
                  matrix[i][j] = Integer.parseInt(S[j]);
          }
          SurroundThe1s ob = new SurroundThe1s();
          int ans = ob.Count(matrix);
          out.println(ans);
      }
      out.close();
  }
}

//} Driver Code Ends


//User function Template for Java
class SurroundThe1s
{
  public int Count(int[][] matrix)
  {
      int n = matrix.length;
      int m = matrix[0].length;
      int count = 0;

      for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
              if (matrix[i][j] == 1) {
                  int zeroCount = 0;
                  // Check the 8 surrounding elements
                  for (int dx = -1; dx <= 1; dx++) {
                      for (int dy = -1; dy <= 1; dy++) {
                          int newRow = i + dx;
                          int newCol = j + dy;
                          if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                              if (matrix[newRow][newCol] == 0) {
                                  zeroCount++;
                              }
                          }
                      }
                  }
                  if (zeroCount % 2 == 0 && zeroCount > 0) {
                      count++;
                  }
              }
          }
      }

      return count;
  }
}