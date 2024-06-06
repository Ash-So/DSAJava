class Solution {
    public static HashMap<Character, String> digitToChar = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs"); // Corrected from 'qprs' to 'pqrs'
        put('8', "tuv");
        put('9', "wxyz");
    }};
    
    public List<String> letterCombinations(String digits) {
        // O(n.4^n)
        if(digits.length() == 0) return new ArrayList();
        
        List<String> res = new ArrayList();
        
        backtrack(0, "", digits, res);
        return res;
    }
    
    public void backtrack(int i, String curr, String digits, List<String> res){
        if(curr.length() == digits.length()){ 
            res.add(curr);
            return;
        }
        
        for(char c : digitToChar.get(digits.charAt(i)).toCharArray()){
            backtrack(i+1, curr + c, digits, res);
        }
    }
}