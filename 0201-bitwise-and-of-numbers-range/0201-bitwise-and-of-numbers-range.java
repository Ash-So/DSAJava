class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // O(1) O(1)
        int count = 0;
        while(left != right){
            left >>= 1;
            right >>=1;
            count++;
        }
        return left << count;
    }
}