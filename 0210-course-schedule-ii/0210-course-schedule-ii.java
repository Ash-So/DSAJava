class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // O(V+E) O(2V)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList());
        }

        for(int[] preq : prerequisites){
            int course = preq[0];
            int pre = preq[1];
            adj.get(pre).add(course);
        }

        int inDegree[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0 ; i < numCourses ; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        
        int[] ans = new int[numCourses];
        int i = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            ans[i] = node;
            i++;
                
            for(int it : adj.get(node)){
                inDegree[it]--;
                
                if(inDegree[it] == 0){
                    q.add(it);
                }
            }    
        }

        if(i == numCourses) return ans;
        int arr[] = {};
        return arr;
    }
}