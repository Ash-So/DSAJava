class Pair{
    int row, col, tm;
    Pair(int row, int col, int tm){
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        //  O(n*m + n*m*4) O(n*m)
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j , 0));
                    vis[i][j] = 2;
                }
                else vis[i][j] = 0;
            }
        }

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};
        int tm = 0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            tm = Math.max(tm, t);
            q.remove();

            for(int i = 0 ; i < 4 ; i++){
                int nrow = r + delRow[i];
                int ncol = c + delCol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] != 2 && grid[nrow][ncol] == 1){
                    q.add(new Pair(nrow, ncol, t+1));
                    vis[nrow][ncol] = 2;
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(vis[i][j] != 2 && grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return tm;
    }
}