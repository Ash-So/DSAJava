class Solution {
    String b;
    HashMap<String, Integer> mpp = new HashMap<>();
    List<List<String>> ans = new ArrayList<>();

    public void dfs(String word, List<String> seq){
        if(word.equals(b)){
            List<String> temp = new ArrayList<>(seq);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }
        int steps = mpp.get(word);
        int sz = word.length();
        for(int i = 0 ; i < sz ; i++){
            for(char ch = 'a' ; ch <= 'z' ; ch++){
                char[] replacedCharArray = word.toCharArray();
                replacedCharArray[i] = ch;
                String replacedWord = new String(replacedCharArray);

                if(mpp.containsKey(replacedWord) == true && mpp.get(replacedWord)+1 == steps){
                    seq.add(replacedWord);
                    dfs(replacedWord, seq);
                    seq.remove(seq.size()-1);
                }
            }
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // Time complexity depends upon the egs there could be many sequences 
        b = beginWord;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int sz = beginWord.length();
        
        Set<String> st = new HashSet<>();
        for(int i = 0 ; i < wordList.size() ; i++){
            st.add(wordList.get(i));
        }
        mpp.put(beginWord, 1);
        st.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.remove();
            int steps = mpp.get(word);

            if(word == endWord) break;

            for(int i = 0 ; i < sz ; i++){
                for(char ch = 'a' ; ch <= 'z' ; ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if(st.contains(replacedWord) == true){
                        q.add(replacedWord);
                        st.remove(replacedWord);
                        mpp.put(replacedWord, steps+1);
                    }
                }
            }
        }
        
        if(mpp.containsKey(endWord) == true){
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, seq);
        }
        return ans;
    }
}

// TLE tho optimized can tell the interviewer
// class Pair{
//     String first;
//     int second;
//     Pair(String first, int second){
//         this.first = first;
//         this.second = second;
//     }
// }

// class Solution {
//     public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//         // Time complexity depends upon the egs there could be many sequences 
//         Set<String> st = new HashSet<>();
//         int n = wordList.size();
//         for(int i = 0 ; i < n ; i++){
//             st.add(wordList.get(i));
//         }

//         Queue<ArrayList<String>> q = new LinkedList<>();
//         ArrayList < String > ls = new ArrayList < > ();
//         ls.add(beginWord);
//         q.add(ls);

//         ArrayList<String>usedOnLevel = new ArrayList<>();
//         usedOnLevel.add(beginWord);
//         int level = 0;

//         List<List<String>> ans = new ArrayList<>();

//         while(!q.isEmpty()){
//             ArrayList<String> vec = q.remove();

//             // Now, erase all words that have been
//             // used in the previous levels to transform
//             if (vec.size() > level) {
//                 level++;
//                 for (String it: usedOnLevel) {
//                     st.remove(it);
//                 }
//             }
//             String word = vec.get(vec.size() - 1);
//             if (word.equals(endWord)) {
//                 if (ans.size() == 0) {
//                     ans.add(vec);
//                 } else if (ans.get(0).size() == vec.size()) {
//                     ans.add(vec);
//                 }
//             }

//             for (int i = 0; i < word.length(); i++) {
//                 for (char c = 'a'; c <= 'z'; c++) {
//                     char replacedCharArray[] = word.toCharArray();
//                     replacedCharArray[i] = c;
//                     String replacedWord = new String(replacedCharArray);

//                     if (st.contains(replacedWord) == true) {
//                         vec.add(replacedWord);
//                         ArrayList<String> temp = new ArrayList<>(vec);
//                         q.add(temp);
//                         // mark as visited on the level 
//                         usedOnLevel.add(replacedWord);
//                         vec.remove(vec.size() - 1);
//                     }
//                 }
//             }
//         }
//         return ans;
//     }
// }