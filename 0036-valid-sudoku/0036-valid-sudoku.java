class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    String str = "#" + board[i][j];
                    if (!seen.add(str + i) || !seen.add(j + str) || !seen.add(i/3 + str + j/3))
                        return false;
                }
            }
        }
        
        return true;
    }
}