// DFS
class Solution {
    public boolean dfs(int start, int col, ArrayList<ArrayList<Integer>> adj, int[] color){
        color[start] = col;

        for(int it : adj.get(start)){
            if(color[it] == -1){
                if(dfs(it, 1 - col, adj, color) == false)
                    return false;
            }
            else if(color[it] == col){
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        // O(N+2E) same as dfs O(n * n*m) n for color, n*m for adj
        int n = graph.length;
        int[] color = new int[n];    
        for(int i = 0 ; i < n ; i++) color[i] = -1;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList());
            for(int j : graph[i]){
                adj.get(i).add(j);
            }
        }

        for(int i = 0 ; i < n ; i++){
            if(color[i] == -1){
                if(dfs(i, 0, adj, color) == false) 
                    return false;
            }
        }
        return true;
    }
};

// // BFS
// class Solution {
//     public boolean check(int start, int n, ArrayList<ArrayList<Integer>> adj, int[] color){
//         Queue<Integer> q = new LinkedList<Integer>();
// 	    q.add(start); 
// 	    color[start] = 0; 

//         while(!q.isEmpty()){
//             int node = q.remove();

//             for(int it : adj.get(node)){
//                 if(color[it] == -1){
//                     color[it] = 1 - color[node];
//                     q.add(it);
//                 }
//                 else if(color[it] == color[node]){
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
//     public boolean isBipartite(int[][] graph) {
//         // O(n*2e) same as dfs O(n*m)
//         int n = graph.length;
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

//         // for(int i = 0 ; i < n ; i++){
//         //     adj.add(new ArrayList());
//         // }

//         for(int i = 0 ; i < n ; i++){
//             adj.add(new ArrayList());
//             for(int j : graph[i]){
//                 adj.get(i).add(j);
//             }
//         }

//         int color[] = new int[n];
//         for(int i = 0 ; i < n ; i++) color[i] = -1;
        
//         for(int i = 0 ; i < n ; i++){
//             if(color[i] == -1){
//                 if(check(i, n, adj, color) == false) return false;
//             }
//         }

//         return true;
//     }
// }