class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // Space Optimization
        // O(n*n) O(2n)
        int n = triangle.size();
        int[] ahead = new int[n];

        for(int j = 0 ; j < n ; j++){
            ahead[j] = triangle.get(n-1).get(j);
        }

        for(int i = n-2 ; i >= 0 ; i--){
            int[] curr = new int[n];
            for(int j = i ; j >= 0 ; j--){
                int down = triangle.get(i).get(j) + ahead[j];
                int diag = triangle.get(i).get(j) + ahead[j+1];
                curr[j] = Math.min(down, diag);
            }
            ahead = curr;
        }

        return ahead[0];

        // // Tabulation
        // // O(n*n) O(n*n)
        // int n = triangle.size();
        // int[][] dp = new int[n][n];

        // for(int j = 0 ; j < n ; j++){
        //     dp[n-1][j] = triangle.get(n-1).get(j);
        // }

        // for(int i = n-2 ; i >= 0 ; i--){
        //     for(int j = i ; j >= 0 ; j--){
        //         int down = triangle.get(i).get(j) + dp[i+1][j];
        //         int diag = triangle.get(i).get(j) + dp[i+1][j+1];
        //         dp[i][j] = Math.min(down, diag);
        //     }
        // }

        // return dp[0][0];
    }
}