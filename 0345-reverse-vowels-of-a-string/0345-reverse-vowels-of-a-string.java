class Solution {
    public boolean isVowel(char y){
        if(y == 'a' || y == 'e' || y == 'i' || y == 'o'
            || y == 'u' || y == 'A' || y == 'E' || y == 'I'
            || y == 'O' || y == 'U'){
                return true;
            }
        return false;
    }

    public String reverseVowels(String s) {
        // O(n) O(n)
        char[] sarr=s.toCharArray();
        int start = 0, end = sarr.length-1;

        while(start < end){
            if(isVowel(sarr[start]) && isVowel(sarr[end])){
                char temp = sarr[start];
                sarr[start] = sarr[end];
                sarr[end] = temp;

                start++;
                end--;
            }
            else if(!isVowel(sarr[start])){
                start++;
            }
            else{
                end--;
            }
        }
        return new String(sarr);
    }
}