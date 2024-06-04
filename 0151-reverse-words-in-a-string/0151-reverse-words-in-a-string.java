class Solution {
    public String reverseWords(String s) {
        // O(n) O(n)
        String ans="";
        for(int i=0;i<s.length();i++){
            StringBuilder str=new StringBuilder();
            while(i<s.length() && (s.charAt(i)!=' ')){
                str.append(s.charAt(i));
                i++;
            }
            if(str.length()!=0){
                ans=" "+str+ans;
            }
        }
        return ans.substring(1);
    }
}