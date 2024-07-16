class Solution {
    public int maxProfit(int[] prices) {
        // Time Optimizied
        // O(N) O(2)
        int min = prices[0], profit = 0;
        for(int i = 1; i < prices.length ;i++){
            if(prices[i] > prices[i-1]) profit += prices[i] - prices[i-1];
        }
        return profit;

        // // Space Optimization
        // // O(N*2) O(2)
        // int n =prices.length;
        // int[] ahead = new int[2];
        // ahead[0] = ahead[1] = 0;

        // for(int ind = n-1 ; ind >= 0 ; ind--){
        //     int[] curr = new int[2];
        //     for(int buy = 0 ; buy <= 1 ; buy++){
        //         int profit = 0;
        //         if(buy == 1){
        //             profit = Math.max(-prices[ind] + ahead[0], 0 + ahead[1]);
        //         }
        //         else{
        //             profit = Math.max(prices[ind] + ahead[1], 0 + ahead[0]);
        //         }
        //         curr[buy] = profit;
        //     }
        //     ahead = curr;
        // }

        // return ahead[1];


        // // Tabulation
        // // O(N*2) O(N*2)
        // int n = prices.length;
        // int[][] dp = new int[n+1][2];
        // dp[n][0] = dp[n][1] = 0;

        // for(int ind = n-1 ; ind >= 0 ; ind--){
        //     for(int buy = 0 ; buy <= 1 ; buy++){
        //         int profit = 0;
        //         if(buy == 1){
        //             profit = Math.max(-prices[ind] + dp[ind+1][0], 0 + dp[ind+1][1]);
        //         }
        //         else{
        //             profit = Math.max(prices[ind] + dp[ind+1][1], 0 + dp[ind+1][0]);
        //         }
        //         dp[ind][buy] = profit;
        //     }
        // }
        // return dp[0][1];
    }
}