class Solution {
    public int maxNonAdjacent(int[] arr){
        int n = arr.length;
        int prev = arr[0], prev2 = 0;
        
        for(int i = 1 ; i < n ; i++){
            int pick = arr[i] + prev2;
            int notPick = prev;
            
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    
    public int rob(int[] nums) {
        // O(n) O(1)
        int n = nums.length;
        
        if(n == 1) return nums[0];
        
        int[] exceptFirst = new int[n];
        for(int i = 1 ; i < n ; i++){
            exceptFirst[i] = nums[i];
        }
        
        int[] exceptLast = new int[n];
        for(int i = 0 ; i < n-1 ; i++){
            exceptLast[i] = nums[i];
        }
        
        return Math.max(maxNonAdjacent(exceptFirst), maxNonAdjacent(exceptLast));
    }
}