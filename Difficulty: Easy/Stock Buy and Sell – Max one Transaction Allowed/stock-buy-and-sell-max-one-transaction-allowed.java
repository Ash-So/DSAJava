// User function Template for Java

class Solution {
    public int maximumProfit(int prices[]) {
        // Code here
        int n = prices.length, mini = prices[0], maxProfit = 0;
        
        for(int i = 0 ; i < n; i++){
            int cost = prices[i] - mini;
            maxProfit = Math.max(cost, maxProfit);
            mini = Math.min(mini, prices[i]);
        }
        
        return maxProfit;
    }
}