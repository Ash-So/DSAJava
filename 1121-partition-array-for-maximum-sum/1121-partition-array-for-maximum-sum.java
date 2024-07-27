class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // Tabulation
        // O(n*k) O(n)
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[n] = 0;
        for(int ind = n-1 ; ind >= 0 ; ind--){
            int len = 0, maxi = Integer.MIN_VALUE, maxSum = Integer.MIN_VALUE;
            for(int j = ind ; j < Math.min(n, ind+k) ; j++){
                len++;
                maxi = Math.max(maxi, arr[j]);
                int sum = (len * maxi) + dp[j+1];
                maxSum = Math.max(maxSum, sum);
            }
            dp[ind] = maxSum;
        }
        return dp[0];
    }
}