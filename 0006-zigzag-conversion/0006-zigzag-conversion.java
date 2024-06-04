class Solution {
    public String convert(String s, int numRows) {
         //O(n) O(n)
        if(numRows == 1) return s;
        
        String res = "";
        for(int r = 0 ; r < numRows ; r++){
            int inc = 2 * (numRows - 1);
            for(int i = r ; i < s.length() ; i += inc){
                res += s.charAt(i);
                if(r > 0 && r < numRows - 1 && (i + inc - 2 * r) < s.length())
                    res += s.charAt(i + inc - 2 * r);
            }
        }
        return res;
    }
}