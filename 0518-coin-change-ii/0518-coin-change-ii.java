class Solution {
    public int change(int amount, int[] coins) {
        // O(n*amount) O(target)
        int[] prev = new int[amount+1];
        
        for(int t = 0 ; t <= amount ; t++){
            prev[t] = ( t % coins[0] == 0 ) ? 1 : 0;
        }
        
        for(int ind = 1 ; ind < coins.length ; ind++){
            int[] curr = new int[amount+1];
            for(int t = 0 ; t <= amount ; t++){
                int notTake = prev[t];
                int take = 0;
                if(t >= coins[ind]) take = curr[t - coins[ind]];
                curr[t] = take + notTake;
            }
            prev = curr;
        }
        
        return prev[amount];
    }
}