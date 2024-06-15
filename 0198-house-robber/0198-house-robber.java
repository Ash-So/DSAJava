class Solution {
    // Space Optimization - Tabulation (BOTTOM UP)
    // O(n) O(1)
    public int rob(int[] nums){
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;
        
        for(int i = 1 ; i < n ; i++){
            int pick = nums[i];
            if(i > 1) pick += prev2;
            int notPick = 0 + prev;
            
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }
        
        return prev;
    }
    
//     MEMOIZATION
//     // O(n) O(n+n)
//     public int f(int idx, int[] nums, int[] dp){
//         if( idx == 0) return nums[0];
//         if(idx < 0) return 0;
        
//         if(dp[idx] != -1) return dp[idx];
        
//         int pick = nums[idx] + f(idx-2, nums, dp);
//         int notPick = 0 + f(idx-1, nums, dp);
        
//         return dp[idx] = Math.max(pick, notPick);
//     }
    
//     public int rob(int[] nums) {
//         // O(n) O(1)
//         int n = nums.length;
//         int[] dp = new int[n];
//         for(int i = 0 ; i < n ; i++){
//             dp[i] = -1;
//         }
//         return f(n-1, nums, dp);
//     }
}