class Solution {
    public int maxArea(int[] height) {
        // O(n) O(1)
        int maxArea = 0;
        int l = 0, r = height.length - 1;

        while(l < r){
            int length = Math.min(height[l], height[r]);
            int area = length * (r - l);
            maxArea = Math.max(area, maxArea);
            if(height[l] < height[r]) l++;
            else r--;
        }

        return maxArea;

        // int maxArea = 0;
        // int i = 0, j = height.length-1;
        
        // while(i < j){
        //     int area = (j-i) * Math.min(height[i], height[j]);
        //     maxArea = Math.max(area, maxArea);
        //     if(height[i] < height [j]) i++;
        //     else j--;
        // }
        
        // return maxArea;
    }
}