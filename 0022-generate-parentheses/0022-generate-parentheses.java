class Solution {
    List<String> res = new ArrayList();
    public List<String> generateParenthesis(int n) {
        StringBuilder temp = new StringBuilder();
        
        backtrack(0, 0, n, temp);
        return res;
    }
    
    public void backtrack(int open, int close, int n, StringBuilder temp){
        if(open == n && close == n){
            res.add(temp.toString());
            return;
        }
        
        if(open < n){
            temp.append('(');
            backtrack(open + 1, close, n, temp);  
            temp.deleteCharAt(temp.length()-1);
        } 
        if(close < open){
            temp.append(')');
            backtrack(open, close + 1,n, temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}