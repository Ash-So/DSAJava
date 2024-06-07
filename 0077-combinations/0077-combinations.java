class Solution {
    // O(nCk)
//     List<List<Integer>> res;
//     public List<List<Integer>> combine(int n, int k) {
//         res = new ArrayList();
        
//         backtrack(1, new ArrayList<Integer>(), n, k);
//         return res;
//     }
    
//     public void backtrack(int start, List<Integer> comb, int n, int k){
//         if(comb.size() == k){
//             res.add(new ArrayList<Integer>(comb));
//             return;
//         }
//         for(int i = start ; i <= n ;i++){
//             comb.add(i);
//             backtrack(i+1, comb, n, k);
//             comb.remove((Integer) i);
//         }
//     }
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> combine(int n, int k){
        List<Integer> temp = new ArrayList();
        
        backtrack(1, n, k, temp);
        return res;
    }
    
    public void backtrack(int start, int n, int k, List<Integer> temp){
        if(k == 0){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        
        if(start > n) return;
        
        temp.add(start);
        backtrack(start+1, n, k-1, temp);
        temp.remove((Integer)start);
        backtrack(start+1, n, k, temp);
    }
}