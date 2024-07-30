class Solution {
    public static int perfectSum(int arr[],int n, int sum) 
	{ 
	    int[] prev = new int[sum+1];
	    
	    if(arr[0] == 0) prev[0] = 2;
	    else prev[0] = 1;
	    
	    if(arr[0] != 0 && arr[0] <= sum) prev[arr[0]] = 1;
	    
	    for(int i = 1 ; i < n ; i++){
	        int[] curr = new int[sum+1];
            curr[0] = 1;
            for(int target = 0 ; target <= sum ; target++){ // target from 0 as we need to also include those subset who have zero in them
                int notTake = prev[target];
                int take = 0;
                if(target >= arr[i]) take = prev[target-arr[i]];
                curr[target] = (take + notTake);
            }
            prev = curr;
	    }
	    
	    return prev[sum];
	} 
    public int findTargetSumWays(int[] nums, int target) {
        // Space Optimization
        // O(n*sum) O(sum)
        int n = nums.length;
        int totalSum = 0;
        for(int val : nums) totalSum += val;
        
        if((totalSum - target < 0) || (totalSum - target) % 2 == 1) return 0;
        return perfectSum(nums, n, (totalSum - target) / 2);
    }
}