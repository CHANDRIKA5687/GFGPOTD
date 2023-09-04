package ninjaslayground;
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
  public static void main(String args[])throws IOException
  {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(in.readLine());
      while(t-- > 0){
          String a[] = in.readLine().trim().split(" ");
          int n = Integer.parseInt(a[0]);
          int m = Integer.parseInt(a[1]);
          char mat[][] = new char[n][m];
          for(int i=0; i<n; i++)
          {
              String S[] = in.readLine().trim().split(" ");
              for(int j=0; j<m; j++)
              {
                  mat[i][j] = S[j].charAt(0);
              }
          }
          
          Solution ob = new Solution();
          char[][] ans = ob.fill(n, m, mat);
          for(int i = 0;i < n;i++) {
              for(int j = 0;j < m;j++) {
                  System.out.print(ans[i][j] + " ");
              }
              System.out.println();
          }
      }
  }
}
//} Driver Code Ends


//User function Template for Java
class Solution {
  static char[][] fill(int n, int m, char a[][]) {
      // Define directions for neighboring cells (up, down, left, right)
      int[] dx = {-1, 1, 0, 0};
      int[] dy = {0, 0, -1, 1};
      
      // Perform BFS starting from 'O's on the border
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
              if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && a[i][j] == 'O') {
                  bfs(a, i, j, n, m, dx, dy);
              }
          }
      }
      
      // Replace remaining 'O's with 'X' and revert 'B' back to 'O'
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
              if (a[i][j] == 'O') {
                  a[i][j] = 'X';
              } else if (a[i][j] == 'B') {
                  a[i][j] = 'O';
              }
          }
      }
      
      return a;
  }
  
  // Perform BFS starting from a cell containing 'O'
  static void bfs(char[][] a, int i, int j, int n, int m, int[] dx, int[] dy) {
      Queue<Integer> queue = new LinkedList<>();
      queue.offer(i * m + j);
      a[i][j] = 'B'; // Mark the cell as visited
      
      while (!queue.isEmpty()) {
          int cell = queue.poll();
          int x = cell / m;
          int y = cell % m;
          
          for (int k = 0; k < 4; k++) {
              int ni = x + dx[k];
              int nj = y + dy[k];
              
              if (ni >= 0 && ni < n && nj >= 0 && nj < m && a[ni][nj] == 'O') {
                  queue.offer(ni * m + nj);
                  a[ni][nj] = 'B'; // Mark the cell as visited
              }
          }
      }
  }
}
