//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String toString(int r, int c){
        return Integer.toString(r) + " " + Integer.toString(c);
    }
    
    void dfs(int row, int col, int[][] grid, int[][] vis, ArrayList<String> vec, int row0, int col0){
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = 1;
        vec.add(toString(row - row0, col - col0)); //row0 n col0 are base coordinates
        
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};
        
        for(int i = 0 ; i < 4 ; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                dfs(nrow, ncol, grid, vis, vec, row0, col0);
            }
        }
    }

    int countDistinctIslands(int[][] grid) {
        // O(n*m + n*m*4) O(n*m)
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Set<ArrayList<String>> st = new HashSet<>();
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    ArrayList<String> vec = new ArrayList<>();
                    dfs(i, j, grid, vis, vec, i, j); // n*m*4
                    st.add(vec);
                }
            }
        } // n*m
        return st.size();
    }
}
