class Solution {
    // O(2^n*k) O(k*x)
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(candidates);
        backtrack(0, temp, target, candidates);
        
        return res;
    }
    
    public void backtrack(int idx, List<Integer> temp, int t, int[] cand){
        if(t == 0){ // O(k)
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for(int i = idx ; i < cand.length ; i++){
            if( i > idx && cand[i] == cand[i-1]) continue;
            if(cand[i] > t) return;
            temp.add(cand[i]);
            backtrack(i+1, temp, t - cand[i], cand);
            temp.remove((Integer)cand[i]);
        }
    }
}