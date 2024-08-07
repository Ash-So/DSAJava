class Solution {
    public int minDistance(String word1, String word2) {
        // Space Optimization
        // O(N*M) O(2*M)
        int n = word1.length(), m = word2.length();
        int[] prev = new int[m+1];

        for(int j = 0 ; j <= m ; j++) prev[j] = j;

        for(int i = 1 ; i <= n ; i++){
            int[] curr = new int[m+1];
            curr[0] = i; // base case: if(j == 0) return i;
            for(int j = 1 ; j <= m ; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    curr[j] = prev[j-1];
                else{
                    int insert = 1 + curr[j-1];
                    int delete = 1 + prev[j];
                    int replace = 1 + prev[j-1];

                    curr[j] = Math.min(insert, Math.min(delete, replace));
                }
            }
            prev = curr;
        }

        return prev[m];

        // Tabulation
        // // O(N*M) O(N*M)
        // int n = word1.length(), m = word2.length();
        // int[][] dp = new int[n+1][m+1];

        // for(int j = 0 ; j <= m ; j++) dp[0][j] = j;
        // for(int i = 0 ; i <= n ; i++) dp[i][0] = i;

        // for(int i = 1 ; i <= n ; i++){
        //     for(int j = 1 ; j <= m ; j++){
        //         if(word1.charAt(i-1) == word2.charAt(j-1))
        //             dp[i][j] = dp[i-1][j-1];
            //     else
            //         insert = 1 + dp[i][j-1];
            //         delete = 1 + dp[i-1][j];
            //         replace = 1 + dp[i-1][j-1];

            //         dp[i][j] = Math.min(1 + dp[i][j-1], Math.min(1 + dp[i-1][j], 1 + dp[i-1][j-1]));
            // }
        // }

        // return dp[n][m];
    }
}