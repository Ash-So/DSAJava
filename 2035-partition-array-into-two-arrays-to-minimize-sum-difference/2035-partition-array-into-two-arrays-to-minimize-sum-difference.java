class Solution {
    // Mett in the Middle
    public int minimumDifference(int[] nums){
        int N = nums.length;
        int n = N/2;
        int total = Arrays.stream(nums).sum(); // O(n)
        
        Map<Integer, List<Integer>> left = new HashMap(); // cant create instance of an interface
        Map<Integer, List<Integer>> right = new HashMap<>();
        
        for(int mask = 0 ; mask < (1<<n) ; mask++){
            int setBits = 0, lsum = 0, rsum = 0;
            for(int i = 0 ; i < n ; i++){
                if((mask & (1<<i)) != 0){
                    setBits++;
                    lsum += nums[i];
                    rsum += nums[n+i];
                }
            }
            if(!left.containsKey(setBits)){
                left.put(setBits, new ArrayList());
            }
            left.get(setBits).add(lsum);
            
            if(!right.containsKey(setBits)){
                right.put(setBits, new ArrayList());
            }
            right.get(setBits).add(rsum);
        }
        
        for(int i = 0 ; i <= n ; i++){ // <= n as it checks for all sizes of subset from 0 to n
            if(left.containsKey(i)){
                Collections.sort(left.get(i));
            }
            if(right.containsKey(i)){
                Collections.sort(right.get(i));
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i <= n ; i++){
            int a = 0, b = right.get(n-i).size() - 1;
            while(a < left.get(i).size() && b >= 0){
                int sum = left.get(i).get(a) + right.get(n-i).get(b);
                int diff = Math.abs(total - 2*sum);
                ans = Math.min(ans, diff);
                if(2*sum > total) b--;
                else a++;
            }
        }
        
        return ans;
    }
    
//     // Tabulation O(nsum) O(sum) WORKS WHEN ARR HAS POSITVE NUMBERS ONLY
//     public int minimumDifference(int[] nums) {
//         int n = nums.length;
//         int sum = 0;
//         for(int i = 0 ; i < n ; i++) sum += nums[i];
        
//         boolean[][] dp = new boolean[n][sum+1];
        
//         for(int i = 0 ;i < n ; i++) dp[i][0] = true;
//         if(nums[0] <= sum)
//             dp[0][nums[0]] = true;
        
//         for(int ind = 1 ; ind < n ; ind++){
//             for(int j = 1 ; j <= sum ; j++){
//                 boolean notTake = dp[ind-1][j];
//                 boolean take = false;
//                 if(nums[ind] <= j) take = dp[ind-1][j - nums[ind]];
                
//                 dp[ind][j] = take || notTake;
//             }
//         }
        
//         int mini = Integer.MAX_VALUE;
//         for(int s1 = 0 ; s1 < sum/2 ; s1++){
//             if(dp[n-1][s1] == true){
//                 mini = Math.min(mini, Math.abs((sum - s1)) - s1);
//             }
//         }
        
//         return mini;
//     }
}