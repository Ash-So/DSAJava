//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj =
                new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, ArrayList<Integer> dfsl){
        vis[node] = 1;
        dfsl.add(node);
        
        for(Integer it : adj.get(node)){
            if(vis[it] == 0){
                dfs(it, adj, vis, dfsl);
            }
        }
    }
    
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // O(N)+O(2*E) recursion for every node, undirected O(2*E), directed O(E) O(N) dfsl+vis+recursion stack space
        int[] vis = new int[V];
        int start = 0;
        ArrayList<Integer> dfsl = new ArrayList<>();
        
        dfs(start, adj, vis, dfsl);
        
        return dfsl;
    }
}