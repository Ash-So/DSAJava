class Solution {
    public void dfs(int row, int col, int[][] vis, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = 1;
        
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        for(int i = 0 ; i < 4 ; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                dfs(nrow, ncol, vis, grid);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        // O(n*m) O(n*m)
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        for(int j = 0 ; j < m ; j++){
            if(vis[0][j] == 0 && grid[0][j] == 1)
                dfs(0, j, vis, grid);

            if(vis[n-1][j] == 0 && grid[n-1][j] == 1)
                dfs(n-1, j, vis, grid);
        }

        for(int i = 0 ; i < n ; i++){
            if(vis[i][0] == 0 && grid[i][0] == 1)
                dfs(i, 0, vis, grid);
                
            if(vis[i][m-1] == 0 && grid[i][m-1] == 1)
                dfs(i, m-1, vis, grid);
        }

        int c = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    c++;
                }
            }
        }
        return c;
    }
}