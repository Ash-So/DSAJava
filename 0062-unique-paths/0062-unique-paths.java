class Solution {
//     // Memoization O(mn) O(mn) + O(pathlength)
//     public int f(int i, int j, int[][] dp){
//         if(i == 0 && j == 0) return 1;
//         if(i < 0 || j < 0) return 0;
        
//         if(dp[i][j] != -1) return dp[i][j];
        
//         int up = f(i-1,j,dp);
//         int left = f(i, j-1,dp);
        
//         return dp[i][j] = up+left;
//     }
    
//     // Recursion O(2^mn) O(path length)
//     public int f(int i, int j){
//         if(i == 0 && j == 0) return 1;
//         if(i < 0 || j < 0) return 0;
        
//         int up = f(i-1,j);
//         int left = f(i, j-1);
        
//         return up+left;
//     }
    
//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m][n];
//         for(int i = 0 ; i < m ; i++){
//             for(int  j = 0 ; j < n ; j++){
//                 if(i == 0 && j == 0) dp[i][j] = 1;
//                 else{
//                     int up = 0, left = 0;
//                     if(i > 0) up = dp[i-1][j];
//                     if(j > 0) left = dp[i][j-1];
//                     dp[i][j] = up + left;
//                 }
//             }
//         }
//         return dp[m-1][n-1];
//     }
    
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for(int i = 0 ; i < n ; i++){
            dp[i] = 0;
        }
        
        for(int i = 0 ; i < m ; i++){
            int[] temp = new int[n];
            for(int t = 0 ; t < n ; t++){
                temp[t] = 0;
            }
            for(int j = 0 ; j < n ; j++){
                if(i == 0 && j == 0) temp[j] = 1;
                else{
                    int up = 0, left = 0;
                    if(i > 0) up = dp[j];
                    if(j > 0) left = temp[j-1];
                    temp[j] = up + left; 
                }
            }
            dp = temp;
        }
        
        return dp[n-1];
    }
}