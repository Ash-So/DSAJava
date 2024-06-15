class Solution {
    public int f(int idx, int[] nums, int[] dp){
        if( idx == 0) return nums[0];
        if(idx < 0) return 0;
        
        if(dp[idx] != -1) return dp[idx];
        
        int pick = nums[idx] + f(idx-2, nums, dp);
        int notPick = 0 + f(idx-1, nums, dp);
        
        return dp[idx] = Math.max(pick, notPick);
    }
    
    public int rob(int[] nums) {
        // O(n) O(1)
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 0 ; i < n ; i++){
            dp[i] = -1;
        }
        return f(n-1, nums, dp);
    }
}