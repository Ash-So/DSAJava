class Solution {
    // O(n*m) O(m)
    public int longestCommonSubsequence(String text1, String text2) {   
        int n = text1.length(), m = text2.length();
        int[] prev = new int[m+1];
        
        // for(int j = 0 ; j <= m ; j++) prev[j] = 0;
        
        for(int i = 1 ; i <= n ; i++){
            int[] curr = new int[m+1];
            for(int j = 1 ; j <= m ; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) 
                    curr[j] = 1 + prev[j-1];
                else
                    curr[j] = Math.max(prev[j], curr[j-1]);
            }
            prev = curr; //(int[]) curr.clone();
        }
        
        return prev[m];
    }
}