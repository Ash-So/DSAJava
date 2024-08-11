//{ Driver Code Starts
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
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

// // BFS
// class Pair {
//     int first;
//     int second;
//     public Pair(int first, int second) {
//         this.first = first;
//         this.second = second; 
//     }
// }
// class Solution {
//     public boolean detect(int src, ArrayList<ArrayList<Integer>> adj, int[] vis){
//         vis[src] = 1;
//         Queue<Pair> q = new LinkedList<>();
//         q.add(new Pair(src, -1));
        
//         while(!q.isEmpty()){
//             int node = q.peek().first;
//             int parent = q.peek().second;
//             q.remove();
            
//             for(int adjNode : adj.get(node)){
//                 if(vis[adjNode] == 0){
//                     vis[adjNode] = 1;
//                     q.add(new Pair(adjNode, node));
//                 }
//                 else if(parent != adjNode)
//                     return true;
//             }
//         }
//         return false;
//     }
//     // Function to detect cycle in an undirected graph.
//     public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
//         // O(N + 2E) + O(N)  O(N) + O(N)
//         int[] vis = new int[V];
//         for(int i = 1 ; i <= V ; i++){
//             if(vis[i-1] == 0){
//                 if(detect(i-1, adj, vis) == true) return true;
//             }
//         }
//         return false;
//     }
// }

// DFS
class Solution {
    public boolean dfs(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        
        for(int adjNode : adj.get(node)){
            if(vis[adjNode] == 0){
                if(dfs(adjNode, node, vis, adj) == true){
                    return true;
                }
            }
            else if(parent != adjNode){
                return true;
            }
        }
        return false;
    }
    
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // O(N + 2E + N ) O(N + N)
        int[] vis = new int[V];
        
        for(int i = 0 ; i < V ; i++){
            if(vis[i] == 0){
                if(dfs(i, -1, vis, adj) == true) return true;
            }
        }
        return false;
    }
}