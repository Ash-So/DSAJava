//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    // Kahn's Topo Sort BFS
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // O(V+E) O(2V)
        int inDegree[] = new int[V];
        for(int i = 0 ; i < V ; i++){
            for(int it : adj.get(i)){
                inDegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        int c = 0;
        for(int i = 0 ; i < V ; i++){
            if(inDegree[i] == 0)
                q.add(i);
        }
        
        while(!q.isEmpty()){
            int node = q.remove();
            c++;
            
            for(int it : adj.get(node)){
                inDegree[it]--;
                
                if(inDegree[it] == 0){
                    q.add(it);
                }
            }
        }
        
        if(c == V) return false;
        else return true;
        
    }
    
    // DFS
    // public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis){
    //     vis[node] = 1;
    //     pathVis[node] = 1;
        
    //     for(int it : adj.get(node)){
    //         if(vis[it] == 0){
    //             if(dfs(it, adj, vis, pathVis) == true) 
    //                 return true;
    //         }
    //         else if(pathVis[it] == 1){
    //             return true;
    //         }
    //     }
        
    //     pathVis[node] = 0;
    //     return false;
    // }
    
    // public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
    //     // O(V+E) O(2V)
    //     int[] vis = new int[V];
    //     int[] pathVis = new int[V];
        
    //     for(int i = 0 ; i < V ; i++){
    //         if(vis[i] == 0){
    //             if(dfs(i, adj, vis, pathVis) == true) return true;
    //         }
    //     }
        
    //     return false;
    // }
}