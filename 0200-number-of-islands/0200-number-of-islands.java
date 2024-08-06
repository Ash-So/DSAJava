class Solution {
    public int numIslands(char[][] grid) {
        // O(n*m) 
        int row = grid.length;
        int col = grid[0].length;
        int num = 0;

        if(row == 0) return 0;

        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    num++;
                }
            }
        }

        return num;
    }

    public void dfs(int i, int j, char[][] grid){
        int row = grid.length;
        int col = grid[0].length;

        if(i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != '1') return;

        grid[i][j] = '0';
        dfs(i+1, j, grid);
        dfs(i, j+1, grid);
        dfs(i-1, j, grid);
        dfs(i, j-1, grid);
    }
}