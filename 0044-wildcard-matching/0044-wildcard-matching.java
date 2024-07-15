class Solution {
    public boolean isMatch(String s, String p) {
        // Space Optimization
        // O(N*M) o(2*M)

        int n = p.length(), m = s.length();
        boolean[] prev = new boolean[m+1] ;
        prev[0] = true;

        for(int j = 1 ; j <= m ; j++) prev[j] = false;

        for(int i = 1 ; i <= n ; i++){
            boolean[] curr = new boolean[m+1] ;
            boolean flag = true;
            for(int k = 1 ; k <= i ; k++){
                if(p.charAt(k-1) != '*'){
                    flag = false;
                    break;
                }
            }
            curr[0] = flag;
            for(int j = 1 ; j <= m ; j++){
                if(p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?')
                curr[j] = prev[j-1];
                else if(p.charAt(i-1) == '*')
                    curr[j] = prev[j] || curr[j-1];
                else curr[j] = false;
            }
            prev = curr;
        }
        return prev[m];
        

        // //  Tabulation 
        // // O(N*M) O(N*M)
        // int n = p.length(), m = s.length();
        // boolean[][] dp = new boolean[n+1][m+1];
        // dp[0][0] = true;

        // for(int j = 1 ; j <= m ; j++) dp[0][j] = false;

        // for(int i = 1 ; i <= n ; i++){
        //     for (int j = 1; j <= i; j++) {
        //         if (p.charAt(j - 1) != '*') {
        //             dp[i][0] = false;
        //             break;
        //         }
        //         else dp[i][0] = true;
        //     }
        // }

        // for(int i = 1 ; i <= n ; i++){
        //     for(int j = 1 ; j <= m ; j++){
                // if(p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?')
                //     dp[i][j] = dp[i-1][j-1];
                // else if(p.charAt(i-1) == '*')
                //     dp[i][j] = dp[i-1][j] || dp[i][j-1];
                // else dp[i][j] = false;
        //     }
        // }
        // return dp[n][m];
    }
} 