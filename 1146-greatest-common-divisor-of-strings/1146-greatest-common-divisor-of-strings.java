class Solution {
    public int gcd(int a, int b){
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public String gcdOfStrings(String str1, String str2) {
        // O(n + m + log(min(n,m))) O(n + m)
        String s1 = str1 + str2;
        String s2 = str2 + str1;

        if(s1.equals(s2)){
            int len = gcd(str1.length(), str2.length());
            return str1.substring(0, len);
        }
        return "";
    }
}