class Solution {
    public int climbStairs(int n) {
        // O(n) O(1)
        int one = 1, two = 1;
        
        for(int i = 0 ; i < n-1 ; i++){
            int temp = one + two;
            two = one;
            one = temp;
        }
        return one;
    }           
}