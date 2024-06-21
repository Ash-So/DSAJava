class Solution {
    public boolean subsetEqualTarget(int[] nums, int sum){
        int n = nums.length;
        boolean[] prev = new boolean[sum+1];
        // for(int i = 0 ; i < sum+1 ; i++) prev[i] = false;
        
        prev[0] = true;
        if(nums[0] <= sum){
            prev[nums[0]] = true;
        }
        
        for(int ind = 1 ; ind < n ; ind++){
            boolean[] curr = new boolean[sum+1];
            curr[0] = true;
            for(int j = 1 ; j <= sum ; j++){
                boolean notTake = prev[j];
                boolean take = false;
                if(nums[ind] <= j) take = prev[j - nums[ind]];
                
                curr[j] = take | notTake;
            }
            prev = curr;
        }
        
        return prev[sum];
    }
    
    public boolean canPartition(int[] nums) {
        // O(n*sum + n) O(sum)
        int n = nums.length;
        int totalSum = 0;
        
        for(int i = 0 ; i < n ; i++) totalSum += nums[i];
        
        if((totalSum % 2) == 1) return false;
            
        int subsetSum = (totalSum / 2);
        return subsetEqualTarget(nums, subsetSum);
    }
}