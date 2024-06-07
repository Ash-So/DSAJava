class Solution {
    // O(2^target*k) O(k*x)
    List<List<Integer>> res = new ArrayList();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<Integer>();
        
        backtrack(0, temp, target, candidates);
        return res;
    }
    
    public void backtrack(int i, List<Integer> temp, int target, int[] candidates){
        if(i == candidates.length){
            if(target == 0){
                res.add(new ArrayList<Integer>(temp)); // O(n)
            }
            return;
        }
        
        if(candidates[i] <= target){
            temp.add(candidates[i]);
            backtrack(i, temp, target - candidates[i], candidates);
            temp.remove((Integer)candidates[i]);
        }
        backtrack(i + 1, temp, target, candidates);
        
    }
}