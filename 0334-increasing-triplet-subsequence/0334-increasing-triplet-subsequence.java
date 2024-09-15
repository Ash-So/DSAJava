class Solution {
    public boolean increasingTriplet(int[] nums) {
        // O(n) O(1)
        if(nums.length < 3){
            return false;
        }

        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        for(int num : nums){
            if(num <= a){
                a = num;
            }
            else if(num <= b){
                b = num; 
            }
            else{
                return true;
            }
        }

        return false;
    }
}