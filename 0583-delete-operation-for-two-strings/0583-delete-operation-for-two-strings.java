class Solution {
    public int minDistance(String s1, String s2) {
        // Space Optmization
        // O(n*n) O(2n)
        int n = s1.length(), m = s2.length();
        int[] prev = new int[m+1];
        
        // for(int j = 0 ; j <= m ; j++) prev[j] = 0;
        
        for(int i = 1 ; i <= n ; i++){
            int[] curr = new int[m+1];
            for(int j = 1 ; j <= m ; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) 
                    curr[j] = 1 + prev[j-1];
                else
                    curr[j] = Math.max(prev[j], curr[j-1]);
            }
            prev = curr; //(int[]) curr.clone();
        }
        
        int lcs = prev[m];

        return n + m - 2*lcs;

        // // Tabulation
        // // o(n*n) O(n*n)
        // int n = s1.length();
        // int m = s2.length();

        // int dp[][] = new int[n + 1][m + 1];

        // for (int rows[] : dp)
        //     Arrays.fill(rows, -1);

        // for (int i = 0; i <= n; i++) {
        //     dp[i][0] = 0;
        // }
        // for (int i = 0; i <= m; i++) {
        //     dp[0][i] = 0;
        // }

        // for (int ind1 = 1; ind1 <= n; ind1++) {
        //     for (int ind2 = 1; ind2 <= m; ind2++) {
        //         if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
        //             dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
        //         else
        //             dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
        //     }
        // }

        // int lcs = dp[n][m];
        // return n + m - 2*lcs;
    }
}