class Solution {
    public int maxProfit(int[] prices) {
        // Space Optimization into N*4
        // O(N*4) O(4)
        int n = prices.length;
        int[] ahead = new int[5];
        int[] curr = new int[5];
        for(int trans = 0 ; trans <= 4 ;trans++) ahead[trans] = 0;
        curr[4] = 0;

        for(int ind = n-1; ind >= 0 ; ind--){
            for(int trans = 0 ; trans <= 3 ;trans++){
                if(trans % 2 == 0){
                    curr[trans] = Math.max(-prices[ind] + ahead[trans+1] , 0 + ahead[trans]);
                }
                else curr[trans] = Math.max(prices[ind] + ahead[trans+1] , 0 + ahead[trans]);
            }
            ahead = curr;
        }
        
        return ahead[0];

        // // Space Optimization
        // // O(N*2*3) O(2*3)
        // int n = prices.length;
        // int[][] after =  new int[2][3];
        // int[][] curr = new int[2][3];

        // for(int ind = n-1 ; ind >= 0 ; ind--){
        //     for(int buy = 0 ; buy <= 1 ; buy++){
        //         for(int cap = 1 ; cap <= 2 ; cap++){
        //             int profit = 0;
        //             if(buy == 1){
        //                 profit = Math.max(-prices[ind] + after[0][cap], 0 + after[1][cap]);
        //             }
        //             else{
        //                 profit = Math.max(prices[ind] + after[1][cap--], 0 + after[0][cap]);
        //             }
        //             curr[buy][cap] = profit;
        //         }
        //     }
        //     after = curr;
        // }

        // return after[1][2];


        // // Tabulation
        // // O(N*2*3) O(N*2*3)
        // int n = prices.length;
        // int[][][] dp = new int[n][2][3];

        // for(int ind = 0 ; ind <= n-1 ; ind++){
        //     for(int buy = 0 ; buy <= 1; buy++){
        //         dp[ind][buy][0] = 0;
        //     }
        // }

        // for(int buy = 0 ; buy <= 1; buy++){
        //     for(int cap = 0 ; cap <= 2 ; cap++){
        //         dp[n][buy][cap] = 0;
        //     }
        // }

        // for(int ind = n-1 ; ind >= 0 ; ind--){
        //     for(int buy = 0 ; buy <= 1 ; buy++){
        //         for(int cap = 1 ; cap <= 2 ; cap++){
        //             int profit = 0;
        //             if(buy == 1){
        //                 profit = Math.max(-prices[ind] + dp[ind+1][0][cap], 0 + dp[ind+1][1][cap]);
        //             }
        //             else{
        //                 profit = Math.max(prices[ind] + dp[ind+1][1][cap--], 0 + dp[ind+1][0][cap]);
        //             }
        //             dp[ind][buy][cap] = profit;
        //         }
        //     }
        // }

        // return dp[0][1][2];
    }
}