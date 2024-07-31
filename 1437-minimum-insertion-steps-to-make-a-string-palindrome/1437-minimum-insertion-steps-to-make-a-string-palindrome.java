class Solution {
    public int minInsertions(String s) {
        // Space Optimization
        // O(n*n) O(2n)
        int n = s.length();
        String t = new StringBuilder(s).reverse().toString();

        int[] prev = new int[n+1];

        for(int j = 0 ; j <= n ; j++) prev[j] = 0;

        for(int i = 1 ; i <= n ; i++){
            int[] curr = new int[n+1];
            for(int j = 1 ; j <= n ; j++){
                if(s.charAt(i-1) == t.charAt(j-1))
                    curr[j] = 1 + prev[j-1];
                else curr[j] = Math.max(prev[j], curr[j-1]);
            }
            prev = curr;
        }

        int lps = prev[n];

        return n - lps;
    }
}