class Solution {
    public int singleNumber(int[] nums) {
        // O(n) O(1)
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans= ans^nums[i];
        }
        return ans;
    }
}