class Solution {
    public String intToRoman(int num) {
        // O(1) O(N)
         int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        // StringBuilder ans = new StringBuilder();
        String res="";
        for(int i = 0 ; i < vals.length && num >=0 ; i++){
            while(num >= vals[i]){
                num -= vals[i];
                // ans.append(roman[i]);
                res += roman[i];
            }
        }
        
        // return ans.toString();
        return res;
    }
}