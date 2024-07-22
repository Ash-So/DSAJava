class Solution {
    public int findNumberOfLIS(int[] nums) {
        // O(N*N + N) O(2*N )
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] count = new int[n];
        Arrays.fill(count, 1);
        int maxi = 1;
        for(int ind = 0 ; ind < n ; ind++){
            for(int prev = 0 ; prev< ind ; prev++){
                if(nums[ind] > nums[prev] && dp[prev] + 1 > dp[ind]){
                    dp[ind] = 1 + dp[prev];
                    count[ind] = count[prev];
                }
                else if(nums[ind] > nums[prev] && dp[prev] + 1 == dp[ind]){
                    count[ind] += count[prev];
                }
            }
            if(dp[ind] > maxi){
                maxi = dp[ind];
            }
        }

        int nos = 0;
        for(int i = 0 ; i < n ; i++){
            if(dp[i] == maxi) nos += count[i];
        }

        return nos;
    }
}