class Solution {
    public void dfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] vis){
        vis[node] = 1;

        for(int it : adjList.get(node)){
            if(vis[it] == 0){
                dfs(it, adjList, vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        // O(N + V + 2*E) O(N)
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            adjList.add(new ArrayList());
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int[] vis = new int[n];
        int c = 0;

        for(int i = 0 ; i < n ; i++){
            if(vis[i] == 0){
                // c++;
                dfs(i, adjList, vis);
                c++;
            }
        }
        return c;
    }
}