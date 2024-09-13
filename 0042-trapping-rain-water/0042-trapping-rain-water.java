class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length-1;
        int maxL = height[l], maxR = height[r];
        int max = 0;

        while(l < r){
            if(maxL < maxR){
                l++;
                maxL = Math.max(maxL, height[l]);
                if(maxL > height[l]) max += maxL - height[l];
            }
            else{
                r--;
                maxR = Math.max(maxR, height[r]);
                if(maxR > height[r]) max += maxR - height[r];
            }
        }

        return max;

        // int l = 0, r = height.length-1;
        // int maxL = 0 , maxR = 0;
        // int ans = 0;
        // while(l<r){
        //     if(height[l] <=height[r]){
        //         if(height[l] >= maxL) maxL = height[l];
        //         else ans += maxL - height[l];
        //         l++;
        //     }
        //     else{
        //         if(height[r] >= maxR) maxR = height[r];
        //         else ans += maxR - height[r];
        //         r--;
        //     }
        // }
        // return ans;
    }
}