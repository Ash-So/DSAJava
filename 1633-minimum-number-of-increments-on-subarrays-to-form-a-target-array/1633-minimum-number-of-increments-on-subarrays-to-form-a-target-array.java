class Solution {
    public int minNumberOperations(int[] target) {
        // O(n) O(1)
        int n = target.length;
        int sum = target[0];

        for(int i = 1 ; i < n ; i++){
            if(target[i] > target[i-1]){
                sum += target[i] - target[i-1];
            }
        }

        return sum;
    }
}