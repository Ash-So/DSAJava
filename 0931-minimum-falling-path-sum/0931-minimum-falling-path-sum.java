class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] dp = new int[m];
        
        for(int j = 0 ; j < m ; j++) dp[j] = matrix[0][j];
        
        for(int i = 1 ; i < n ; i++){
            int[] temp = new int[m];
            // for(int t = 0 ; t < m ; t++) temp[t] = 0;
            for(int j = 0 ; j < m ; j++){
                int up = matrix[i][j] + dp[j];
                
                int ld = matrix[i][j], rd = matrix[i][j];
                if(j - 1 >= 0) ld += dp[j-1];
                else ld = Integer.MAX_VALUE;
                
                if(j < m-1) rd += dp[j+1];
                else rd = Integer.MAX_VALUE;
                
                temp[j] = Math.min(up, Math.min(ld, rd));
            }
            dp = temp;
        }
        
        int mini = Integer.MAX_VALUE;
        for(int j = 0 ; j < m ; j++){
            mini = Math.min(mini, dp[j]);
        }
        
        return mini;
    }
    
//     public int minFallingPathSum(int[][] matrix) {
//         // O(nm) O(m)
//         int n = matrix.length;
//         int m = matrix[0].length;
//         int[] prev = new int[m];
        
//         for(int j = 0 ; j < m ; j++){
//             prev[j] = matrix[0][j];
//         }
        
//         for(int i = 1 ; i < n ; i++){
//             int[] curr = new int[m];
//             for(int j = 0 ; j < m ; j++){
//                 int up = matrix[i][j] + prev[j];
//                 int ld = matrix[i][j];
//                 if(j - 1 >= 0) {
//                     ld += prev[j - 1];
//                 } else {
//                     ld += Integer.MAX_VALUE; 
//                 }
//                 int rd = matrix[i][j];
//                 if (j + 1 < m) {
//                     rd += prev[j + 1];
//                 } else {
//                     rd += Integer.MAX_VALUE; 
//                 }
                
//                 curr[j] = Math.min(up, Math.min(ld, rd));
//             }
//             prev = curr;
//         }
//         int mini = Integer.MAX_VALUE;
//         for(int j = 0 ; j < m ; j++){
//             mini = Math.min(mini, prev[j]);
//         }
        
//         return mini;
//     }
}