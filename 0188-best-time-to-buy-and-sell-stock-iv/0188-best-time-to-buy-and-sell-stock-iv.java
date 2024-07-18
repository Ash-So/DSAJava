class Solution {
    public int maxProfit(int k, int[] prices) {
        // Refer to leetcode 123 Best Time to Buy and Sell Stock III
        // Space Optimization
        // O(N*k) O(k)
        int n = prices.length;
        int[] ahead = new int[2*k+1];
        int[] curr = new int[2*k+1];
        // no need for base cases as in starting the array will have 0 only n that is our base case too

        for(int ind = n-1 ; ind >= 0 ; ind--){
            for(int trans = 0 ; trans <= 2*k-1 ; trans++){
                if(trans % 2 == 0){
                    curr[trans] = Math.max(-prices[ind] + ahead[trans+1] , 0 + ahead[trans]);
                }
                else curr[trans] = Math.max(prices[ind] + ahead[trans+1] , 0 + ahead[trans]);
            }
            ahead = curr;
        }

        return ahead[0];
    }
}