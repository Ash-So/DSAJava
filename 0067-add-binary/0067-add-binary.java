class Solution {
    public String addBinary(String a, String b) {
        int alen = a.length()-1;
        int blen = b.length()-1;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        
        while(alen >= 0 || blen >=0 || carry > 0){
            int sum = ((alen < 0) ? 0 : (a.charAt(alen--) - '0')) +
                      ((blen < 0) ? 0 : (b.charAt(blen--) - '0')) +
                      carry;
            
            ans.append(Integer.toString(sum & 1));
            carry = (sum >> 1) & 1;
        }
        return ans.reverse().toString();
    }
}