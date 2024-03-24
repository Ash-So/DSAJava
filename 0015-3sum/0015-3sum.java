class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        for(int i = 0 ; i < nums.length-2 ; i++){
            if(i ==0 || (i > 0 && nums[i] != nums[i-1])){
                int target = 0 - nums[i];
                int l = i+1, r = nums.length - 1;
                
                while(l < r){
                    int threesum = nums[i] + nums[l] + nums[r];
                    if(threesum > 0) r--;
                    else if (threesum < 0) l++;
                    else{
                        // List<Integer> miniAns = new ArrayList<Integer>();
                        // miniAns.add(nums[i]);
                        // miniAns.add(nums[l]);
                        // miniAns.add(nums[r]);
                        // ans.add(miniAns);
                        ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while(l<r && nums[l] == nums[l+1]) l++;
                        while(l<r && nums[r] == nums[r-1]) r--;
                        r--;
                        l++;
                    }
                }
            }
        }
        return ans;
    }
}