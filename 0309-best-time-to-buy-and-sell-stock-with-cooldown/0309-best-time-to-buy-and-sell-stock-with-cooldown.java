class Solution {
    public int maxProfit(int[] prices) {
        // Similar to Best Time to Buy and Sell Stock II
        // Space Optimization
        // O() O()
        // int n = prices.length;
        // int[] front2 = new int[2];
        // int[] front1 = new int[2];
        // int[] curr = new int[2];

    
        // Tabulation
        // O(N) O(2*N)
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        for(int ind = n-1 ; ind >= 0 ; ind--){
            dp[ind][1] = Math.max(-prices[ind] + dp[ind+1][0], 0 + dp[ind+1][1]);

            dp[ind][0] = Math.max(prices[ind] + dp[ind+2][1], 0 + dp[ind+1][0]);
        }
        return dp[0][1];

        // O(2*N) O(2*N)
        // int n = prices.length;
        // int[][] dp = new int[n+2][2];
        // for(int ind = n-1 ; ind >= 0 ; ind--){
        //     for(int buy = 0 ; buy <= 1 ; buy++){
        //         int profit = 0;
        //         if(buy == 1){
        //             profit = Math.max(-prices[ind] + dp[ind+1][0], 0 + dp[ind+1][1]);
        //         }
        //         else{
        //             profit = Math.max(prices[ind] + dp[ind+2][1], 0 + dp[ind+1][0]);
        //         }
        //         dp[ind][buy] = profit;
        //     }
        // }
        // return dp[0][1];
        
    }
}