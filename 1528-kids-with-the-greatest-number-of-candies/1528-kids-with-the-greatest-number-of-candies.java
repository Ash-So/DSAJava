class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // O(n) O(n)
        int max = 0;
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0 ; i < candies.length ; i++){
            if(candies[i] > max){
                max = candies[i];
            }
        }

        for(int i = 0 ; i < candies.length ; i++){
            if(candies[i] + extraCandies >= max){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        }

        return ans;
    }
}