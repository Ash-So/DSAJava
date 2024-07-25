class Solution {
    public int minCost(int n, int[] cuts) {
        // Tabulation
        // O(N*N*N) O(N*N)
        ArrayList<Integer> cut = new ArrayList<>();
        for (int value : cuts) {
            cut.add(value);
        }
        cut.add(n);
        cut.add(0);
        Collections.sort(cut);

        int c = cuts.length;
        int[][] dp = new int[c+2][c+2];

        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }

        for(int i = c ; i >= 1 ; i--){
            for(int j = 1 ; j <= c ; j++){
                if(i > j) continue;
                int mini = Integer.MAX_VALUE;
                for(int ind = i ; ind <= j ; ind++){
                    int cost = cut.get(j+1) - cut.get(i-1) + dp[i][ind-1] + dp[ind+1][j];
                    mini = Math.min(mini, cost);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][c];
    }
}