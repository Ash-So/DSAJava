class Solution {
    // O(N*N + L + NlogN) O(N) L = Length of the longest string in words
    public Comparator<String> comp = (s1, s2) -> s1.length() - s2.length(); // Sorting in ascending order
    public boolean checkPossible(String s1, String s2){
        if(s1.length() != s2.length() + 1) return false;
        int first = 0, second = 0;
        while(first < s1.length()){
            if(second < s2.length() && s1.charAt(first) == s2.charAt(second)){
                first++;
                second++;
            }
            else{
                first++;
            }
        }
        return first == s1.length() && second == s2.length();
    }
    public int longestStrChain(String[] words) {
        int n = words.length;
        List<String> word = Arrays.asList(words); 
        word.sort(comp);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxi = -1;
        
        for(int ind = 0 ; ind < n ; ind++){
            for(int prev = 0 ; prev <= ind-1 ; prev++){
                if(checkPossible(words[ind], words[prev]) && 1 + dp[prev] > dp[ind]){
                    dp[ind] = 1 + dp[prev];
                }
            }
            if(dp[ind] > maxi){
                maxi = dp[ind];
            }
        }
        return maxi;
    }
}