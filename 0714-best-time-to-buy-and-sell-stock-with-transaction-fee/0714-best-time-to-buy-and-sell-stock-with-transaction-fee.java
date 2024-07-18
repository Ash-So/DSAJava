class Solution {
    public int maxProfit(int[] prices, int fee) {
        // Similar to buy n sell stock II
        // Space Optimization
        // O(N) O(2)
        int n =prices.length;
        int[] ahead = new int[2];
        ahead[0] = ahead[1] = 0;

        for(int ind = n-1 ; ind >= 0 ; ind--){
            int[] curr = new int[2];
            curr[1] = Math.max(-prices[ind] + ahead[0], 0 + ahead[1]);
            curr[0] = Math.max(prices[ind] - fee + ahead[1], 0 + ahead[0]);
            
            ahead = curr;
        }

        return ahead[1];
    }
}