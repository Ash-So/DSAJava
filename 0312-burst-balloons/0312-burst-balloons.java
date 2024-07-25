class Solution {
    public int f(int i, int j, ArrayList<Integer> num){
        if(i > j) return 0;

        int maxi = Integer.MIN_VALUE;
        for(int ind = i ; ind <= j ; ind++){
            int cost = num.get(i-1)*num.get(ind)*num.get(j+1) + f(i, ind-1, num) + f(ind+1, j, num);
            maxi = Math.max(maxi, cost);
        }

        return maxi;
    }
    public int maxCoins(int[] nums) {
        // // Recursive
        // // O(exponential) O(recursive stack space) 
        // ArrayList<Integer> num = new ArrayList<>();
        // num.add(1);
        // for(int val : nums){
        //     num.add(val);
        // }
        // num.add(1);
        // int n = nums.length;

        // return f(1, n, num);

        // Tabulation
        // O() O()
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        for(int val : nums){
            a.add(val);
        }
        a.add(1);
        int n = nums.length;
        // int[][] dp = new int[n + 2][n + 2];

        // // Iterate from the end to the beginning
        // for (int i = n; i >= 1; i--) {
        //     for (int j = 1; j <= n; j++) {
        //         if (i > j) continue;
        //         int maxi = Integer.MIN_VALUE;
                
        //         // Iterate through possible indices to split the array
        //         for (int ind = i; ind <= j; ind++) {
        //             int cost = a.get(i - 1) * a.get(ind) * a.get(j + 1) +
        //                        dp[i][ind - 1] + dp[ind + 1][j];
        //             maxi = Math.max(maxi, cost);
        //         }
        //         dp[i][j] = maxi;
        //     }
        // }
        // return dp[1][n];
        int[][] dp = new int[n+2][n+2];

        for(int i = n ; i >= 1 ; i--){
            for(int j = 1 ; j <= n ; j++){
                if(i > j) continue;

                int maxi = Integer.MIN_VALUE;
                for(int ind = i ; ind <= j ; ind++){
                    int cost = a.get(i-1)*a.get(ind)*a.get(j+1) 
                            + dp[i][ind-1] + dp[ind+1][j];
                    maxi = Math.max(maxi, cost);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
    }
}