class Solution {
    public void rotate(int[] nums, int k) {
        // // TC: O(N) SC: O(N)
        // int[] res= new int[nums.length];
        // for(int i = 0; i<nums.length ;i++){
        //     res[(i+k)%nums.length] = nums[i];
        // }
        // for(int i = 0;i<nums.length;i++){
        //     nums[i] = res[i];
        // }
        
        // TC: O(N) SC: O(1)
        k = k % nums.length;
        int l = 0, r = nums.length-1;
        while(l < r){
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++; r--;
        }
        
        l = 0; r = k-1;
        while(l < r){
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++; r--;
        }
        
        l = k; r = nums.length-1;
        while(l < r){
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++; r--;
        }
    }
}