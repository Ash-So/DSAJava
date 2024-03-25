class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, bottom = matrix.length-1;
        int left = 0, right = matrix[0].length-1;
        List<Integer> result = new ArrayList<Integer>();
        
        while(top <= bottom && left <= right){
            for(int j = left; j <= right ; j++){
                result.add(matrix[top][j]);
            }
            top++;
            for(int i = top ; i <= bottom ; i++){
                result.add(matrix[i][right]);
            }
            right--;
            if(top <= bottom){
                for(int j = right; j >= left ; j--){
                result.add(matrix[bottom][j]);
                }
            }
            bottom--;
            if(left <= right){
                for(int i = bottom ; i >= top ; i--){
                result.add(matrix[i][left]);
                }
            }
            left++;
        }
        return result;
    }
}