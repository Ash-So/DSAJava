class Solution {
    public int coinChange(int[] coins, int amount) {
        // O(n*amount) O(target)
        int[] prev = new int[amount+1];
        
        for(int t = 0 ; t <= amount ; t++){
            if(t % coins[0] == 0) prev[t] = t / coins[0];
            else prev[t] = (int) Math.pow(10, 9);
        }
        
        for(int ind = 1 ; ind < coins.length ; ind++){
            int[] curr = new int[amount+1];
            for(int t = 0 ; t <= amount ; t++){
                int notTake = 0 + prev[t];
                int take = (int) Math.pow(10, 9);
                if(t >= coins[ind]) take = 1 + curr[t - coins[ind]];
                curr[t] = Math.min(take, notTake);
            }
            prev = curr;
        }
        
        int ans = prev[amount];
        if(ans >= (int) Math.pow(10, 9)) return -1;
        else return prev[amount];
    }
}  