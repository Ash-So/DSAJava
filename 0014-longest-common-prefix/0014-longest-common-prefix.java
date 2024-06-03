class Solution {
    public String longestCommonPrefix(String[] strs) {
        // O(nm) O(1)
        String ans = "";
        
        for(int i = 0 ; i < strs[0].length() ; i++){
            for(String s : strs){
                if( i == s.length() || s.charAt(i) != strs[0].charAt(i)){
                    return ans;
                }
            }
            ans += strs[0].charAt(i);
        }
        return ans;
    }
}