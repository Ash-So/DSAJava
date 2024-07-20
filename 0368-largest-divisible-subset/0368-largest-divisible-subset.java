class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Similar to lis
        // O(N*N + N) O(3N)
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        Arrays.fill(hash, 1);
        
        int maxi = -1;
        int last_index = -1;
        
        for(int ind = 0 ; ind < n ; ind++){
            hash[ind] = ind;
            for(int prev = 0 ; prev <= ind-1 ; prev++){
                if((nums[ind] % nums[prev] == 0) && 1 + dp[prev] > dp[ind]){
                    dp[ind] = 1 + dp[prev];
                    hash[ind] = prev;
                }
            }
            if(dp[ind] > maxi){
                maxi = dp[ind];
                last_index = ind;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(nums[last_index]);
        
        while(hash[last_index] != last_index){
            last_index = hash[last_index];
            ans.add(nums[last_index]);
        }
        // Collections.reverse(ans);
        return ans;
    }
}