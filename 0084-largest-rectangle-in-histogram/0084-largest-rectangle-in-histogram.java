class Solution {
    public int largestRectangleArea(int[] heights) {
        //  O(N) O(N)
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for(int i = 0 ; i <= n ; i++){
            while(!st.empty() && (i == n || heights[st.peek()] >= heights[i])){
                int h = heights[st.peek()];
                st.pop();
                int width;
                if(st.empty()) width = i;
                else width = i - st.peek() - 1;
                maxArea = Math.max(maxArea, width*h);
            }
            st.push(i);
        }

        return maxArea;

        // O(4N) O(3N)
        // int n = heights.length;
        // Stack < Integer > st = new Stack < > ();
        // int leftSmall[] = new int[n];
        // int rightSmall[] = new int[n];
        // for (int i = 0; i < n; i++) {
        //     while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
        //         st.pop();
        //     }

        //     if (st.isEmpty()) leftSmall[i] = 0;
        //     else leftSmall[i] = st.peek() + 1;
        //     st.push(i);
        // }

        // // clear the stack to be re-used
        // while (!st.isEmpty()) st.pop();

        // for (int i = n - 1; i >= 0; i--) {
        //     while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
        //         st.pop();
        //     }

        //     if (st.isEmpty()) rightSmall[i] = n - 1;
        //     else rightSmall[i] = st.peek() - 1;

        //     st.push(i);
        // }

        // int maxA = 0;
        // for (int i = 0; i < n; i++) {
        //     maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
        // }
        // return maxA;
    }
}