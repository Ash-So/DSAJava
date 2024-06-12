class Solution {
    // O(2^n * n) n = length of string and we have 2 options either we partition or not, where *n is the length due to travaresing all the elements
    List<List<String>> res = new ArrayList();
    public List<List<String>> partition(String s) {
        List<String> curr = new ArrayList<String>();
        
        backtrack(0, s, curr);
        return res;
    }
    
    public void backtrack(int idx, String s, List<String> curr){
        if(idx == s.length()){
            res.add(new ArrayList<String>(curr));
            return;
        }
        
        for(int i = idx ; i < s.length() ; i++){
            if(isPalindrome(s, idx, i)){
                curr.add(s.substring(idx, i+1));
                backtrack(i+1, s, curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
        
    }
}