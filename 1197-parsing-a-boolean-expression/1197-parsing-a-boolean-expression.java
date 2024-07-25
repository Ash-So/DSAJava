class Solution {
    public boolean parseBoolExpr(String expression) {
        // O(n) O(n)
        int n = expression.length();
        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < n ; i++){
            char ch = expression.charAt(i);

            if(ch == ')'){
                HashSet<Character> hp = new HashSet<>();
                while(st.peek() != '('){
                    hp.add(st.pop());
                }
                st.pop();  // remove '('
                char op = st.pop();
                if(op == '!'){
                    st.push(hp.contains('t') ? 'f' : 't');
                }
                else if(op == '&'){
                    st.push(hp.contains('f') ? 'f' : 't');
                }
                else{
                    st.push(hp.contains('t') ? 't' : 'f');
                }
            }
            else if(ch != ','){
                st.push(ch);
            }
        }
        return st.peek() == 't' ? true : false;
    }
}