class Solution {
    public int singleNonDuplicate(int[] nums) {
        // // O(n) O(1)
        // int ans=0;
        // for(int i=0;i<nums.length;i++){
        //     ans= ans^nums[i];
        // }
        // return ans;
        
        // O(logn) O(1)
        int left=0, right=nums.length-1;
        while(left<right){
            int mid=(left+right)/2;
            
            if((mid%2 == 0 && nums[mid]==nums[mid+1]) || ( mid%2 == 1 && nums[mid]==nums[mid-1])){
                left = mid+1;
            }
            else right = mid;
        }
        return nums[left];
    }
}