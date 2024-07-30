//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String ss = br.readLine();
            String[] S = ss.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.all_longest_common_subsequences(s, t);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static private Set<String> backtrack(String s, String t, int i, int j, int[][] dp, Map<String, Set<String>> memo) {
        // Base case: when we reach the end of either string
        if (i == 0 || j == 0) {
            Set<String> emptySet = new HashSet<>();
            emptySet.add("");
            return emptySet;
        }

        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        Set<String> resultSet = new HashSet<>();
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            Set<String> prevSet = backtrack(s, t, i - 1, j - 1, dp, memo);
            for (String str : prevSet) {
                resultSet.add(str + s.charAt(i - 1));
            }
        } else {
            if (dp[i - 1][j] >= dp[i][j - 1]) {
                resultSet.addAll(backtrack(s, t, i - 1, j, dp, memo));
            }
            if (dp[i][j - 1] >= dp[i - 1][j]) {
                resultSet.addAll(backtrack(s, t, i, j - 1, dp, memo));
            }
        }

        memo.put(key, resultSet);
        return resultSet;
    }
    
    public List<String> all_longest_common_subsequences(String s1, String s2) {
        // Tabulation
        // O(n*m)[dp] + O(2^(n*m))[backtracking] + O(klogk)[sorting with k no. of lcs string]  O(n*m)[dp] + O(2^(n*m))[backtracking]
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n + 1][m + 1];
        for (int rows[] : dp)
            Arrays.fill(rows, -1);
        
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }

        // // To print only one lcs
        // int len = dp[n][m];
        // int idx = len-1;
        // StringBuilder str = new StringBuilder();
        
        // int i = s1.length(), j = s2.length();
        // while(i > 0 && j > 0){
        //     if(s1.charAt(i-1) == s2.charAt(j-1)){
        //         str.append(s1.charAt(i-1));
        //         idx--;
        //         i--;
        //         j--;
        //     }
        //     else if(dp[i-1][j] > dp[i][j-1]){
        //         i--;
        //     }
        //     else j--;
        // }
        // return str.reverse().toString();
        
        Map<String, Set<String>> memo = new HashMap<>();
        Set<String> lcsSet = backtrack(s1, s2, n, m, dp, memo);
        
        // Convert set to list and sort
        List<String> result = new ArrayList<>(lcsSet);
        result.sort((a, b) -> a.compareTo(b));
        return result;
    }
}