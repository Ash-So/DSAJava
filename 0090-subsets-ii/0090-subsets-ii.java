class Solution {
    List<List<Integer>> res = new ArrayList();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> temp = new ArrayList<Integer>();
        
        Arrays.sort(nums);
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
        
        while(idx+1 < nums.length && nums[idx] == nums[idx+1]){
            idx++;
        }
        solve(idx+1, nums, temp);
    }
}