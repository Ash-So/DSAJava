class Pair{
    String first;
    int second;
    Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //  O(N * M * 26) + O(1) for set; O(N)Where N = size of wordList Array and M = word length of words present in the wordList
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Set<String> st = new HashSet<>();
        int len = wordList.size();
        for(int i = 0 ; i < len ; i++){
            st.add(wordList.get(i));
        }
        st.remove(beginWord);

        // O(n)
        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();

            if(word.equals(endWord) == true) return steps;
            // O(word.length() * 26)
            for(int i = 0 ; i < word.length() ; i++){
                char og = word.charAt(i);

                for(char ch = 'a' ; ch <= 'z' ; ch++){
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;

                    String replacedWord = new String(replacedCharArray);
                    if(st.contains(replacedWord) == true){
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}