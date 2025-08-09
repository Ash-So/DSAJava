class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        int n = arr.length;
        boolean ans = false;
        HashMap<Integer, Integer> mp = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++){
            int comp = target - arr[i];
            if(mp.containsKey(comp)){
                ans = true;
            }
            else{
                mp.put(arr[i], i);
            }
        }
        
        return ans;
    }
}