class Solution {
    public int maximumLength(String s) {
        HashMap<String, Integer> mp = new HashMap<>();
        int n = s.length();

        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j <= n ; j++){
                String str = s.substring(i, j);
                if(mp.containsKey(str)){
                    mp.put(str, mp.get(str) + 1);
                }
                else{
                    mp.put(str, 1);
                }
            }
        }

        int len = 0;
        for(Map.Entry<String, Integer> entry : mp.entrySet()){
            String str = entry.getKey();
            int strCount = entry.getValue();
            
            if(strCount >= 3){
                Set<Character> set = new HashSet();
                for(int j = 0 ; j < str.length() ; j++){
                    set.add(str.charAt(j));
                }
                if(set.size() == 1){
                    len = Math.max(len, str.length());
                }
            }
        }

        return (len == 0) ? -1 : len;
    }
}