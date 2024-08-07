class Solution {
    public int lengthOfLastWord(String s) {
        // O(N) O(1)
        int i = s.length() - 1, len = 0;
        
        while(s.charAt(i) == ' ' ){
            i--;
        }
        while(i>=0 && s.charAt(i) != ' '){
            len++;
            i--;
        }
        return len;
    }
}