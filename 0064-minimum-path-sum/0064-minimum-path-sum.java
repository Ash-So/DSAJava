class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int prev[] = new int[m];
        
        for(int i = 0 ; i < n ; i++){
            int[] curr = new int[m];
            for(int t = 0 ; t < m ; t++) curr[t] = -1;
            for(int j = 0 ; j < m ; j++){
                if(i == 0 && j == 0) curr[j] = grid[0][0];
                else{
                    int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                    if(i > 0) up = grid[i][j] + prev[j];
                    if(j > 0) left = grid[i][j] + curr[j-1];
                    
                    curr[j] = Math.min(up, left);
                }
            }
            prev = curr;
        }
        
        return prev[m-1];
    }
}