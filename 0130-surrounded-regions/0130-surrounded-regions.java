class Solution {
    public void dfs(int row, int col, int[][] vis, char[][] board){
        int m = board.length;
        int n = board[0].length;
        vis[row][col] = 1;

        // check for right, bottom, left, down
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        for(int i = 0 ; i < 4 ; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] != 1 && board[nrow][ncol] == 'O'){
                dfs(nrow, ncol, vis, board);
            }
        }
    }

    public void solve(char[][] board) {
        // O(n*m) O(n*m)
        int n = board[0].length;
        int m = board.length;
        int[][] vis = new int[m][n];

        // traverse 1st row and last row
        for(int j = 0 ; j < n ; j++){
            // 1st row
            if(vis[0][j] != 1 && board[0][j] == 'O'){
                dfs(0, j, vis, board);
            }

            // last row
            if(vis[m-1][j] != 1 && board[m-1][j] == 'O'){
                dfs(m-1, j, vis, board);
            }
        }

        for(int i = 0 ; i < m ; i++){
            // 1st col
            if(vis[i][0] != 1 && board[i][0] == 'O'){
                dfs(i, 0, vis, board);
            }

            // last col
            if(vis[i][n-1] != 1 && board[i][n-1] == 'O'){
                dfs(i, n-1, vis, board);
            }
        }

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(vis[i][j] != 1 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}