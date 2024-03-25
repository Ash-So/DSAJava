class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Hashset has searching O(1) and adding O(1)
        // TC: O(81) SC: O(n)
        HashSet<String> seen = new HashSet(); 
        for(int i = 0; i < 9 ;i++){
            for(int j = 0 ; j < 9; j++){
                if(board[i][j] != '.'){
                    if(!seen.add("row"+i+board[i][j]) || 
                  !seen.add("col"+j+board[i][j]) ||
                  !seen.add("box"+(i/3)+"-"+(j/3)+board[i][j])) return false;
                }
            }
        }
        return true;
    }
}