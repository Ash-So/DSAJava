class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<Integer>();
        
        solve(0, nums, temp);
        return res;
    }
    
    public void solve(int idx, int[] nums, List<Integer> temp){
        if(idx == nums.length){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        
        temp.add(nums[idx]);
        solve(idx+1, nums, temp);
        temp.remove((Integer)nums[idx]);
        solve(idx+1, nums, temp);
    }
}