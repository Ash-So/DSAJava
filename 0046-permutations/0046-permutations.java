class Solution {
    // O(n*n!)
    List<List<Integer>> res = new ArrayList();
    HashSet<Integer> st = new HashSet<Integer>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> temp = new ArrayList();
        
        backtrack(nums, temp);
        return res;
    }
    
    public void backtrack(int[] nums, List<Integer> temp){
        if(temp.size() == nums.length){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for(int i = 0 ; i < nums.length ; i++){
            if(!st.contains(nums[i])){
                temp.add(nums[i]);
                st.add(nums[i]);
                backtrack(nums, temp);
                temp.remove((Integer)(nums[i]));
                st.remove(nums[i]);
            }
        }
    }
}