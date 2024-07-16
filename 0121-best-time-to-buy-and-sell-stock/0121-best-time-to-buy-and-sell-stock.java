class Solution {
    public int maxProfit(int[] prices) {
        // O(N) O(1)
        // if(prices.length < 2) return 0;
        int mini = prices[0], profit = 0;

        for(int i = 0 ; i < prices.length ; i++){
            int cost = prices[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, prices[i]);
        }
        return profit;

        // if(prices.length < 2) return 0;
        // int min = prices[0], profit = 0;
        
        // for(int i = 0; i < prices.length ; i++){
        //     if(prices[i] - min > profit) profit =  prices[i] - min;
        //     if(prices[i] < min) min = prices[i];
        // }
        
        // return profit;
    }
}