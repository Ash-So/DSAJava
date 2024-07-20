class Solution {
    public int lengthOfLIS(int[] nums) {
        // Tabulation
        // O(N*N) O(N)
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxi = 1;
        for(int ind = 0 ; ind < n ; ind++){
            for(int prev = 0 ; prev <= ind ; prev++){
                if(nums[prev] < nums[ind])
                    dp[ind] = Math.max(1 + dp[prev], dp[ind]);
            }
            maxi = Math.max(maxi, dp[ind]);
        }
        return maxi;

        // // Space optimization
        // // O(N*N) O(2*N)
        // int n = nums.length;
        // int[] curr = new int[n+1];
        // int[] next = new int[n+1];
        
        // for(int ind = n-1 ; ind >= 0 ; ind--){
        //     for(int prev_ind = ind-1 ; prev_ind >= -1 ; prev_ind--){
        //         int len = 0 + next[prev_ind+1];
        //         if(prev_ind == -1 || nums[ind] > nums[prev_ind])
        //             len = Math.max(len, 1 + next[ind+1]);
        //         curr[prev_ind+1] = len;
        //     }
        //     next = curr;
        // }
        // return curr[-1+1];

        // // Tabulation
        // // O(N*N) 0(N+1 * N+1)
        // int n = nums.length;
        // int[][] dp = new int[n+1][n+1];
        // // no need for base case as everything in the dp is already 0
        // for(int ind = n-1 ; ind >= 0 ; ind--){
        //     for(int prev_ind = ind-1 ; prev_ind >= -1 ; prev_ind--){
        //         int len = 0 + dp[ind+1][prev_ind+1];
        //         if(prev_ind == -1 || nums[ind] > nums[prev_ind])
        //             len = Math.max(len, 1 + dp[ind+1][ind+1]);
        //         dp[ind][prev_ind+1] = len;
        //     }
        // }
        // // we are adding +1 at every prev_ind as we are doinf coordinate shify cuz -1 can't be accessed
        // return dp[0][-1+1];
    }
}  