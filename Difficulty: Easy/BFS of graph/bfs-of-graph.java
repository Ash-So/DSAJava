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
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends

 
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // O(N)+O(2*E) queue has N nodes, inner for loop works for all the degrees O(2N) QUEUE+BFS LIST 
        int vis[] = new int[V];
        vis[0] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        ArrayList<Integer> bfs = new ArrayList<>();
        
        while(!q.isEmpty()){
            Integer node = q.remove();
            bfs.add(node);
             
            for(Integer it : adj.get(node)){
                if(vis[it] == 0){
                    vis[it] = 1;
                    q.add(it);
                }
            }
        }
        
        return bfs;
    }
}