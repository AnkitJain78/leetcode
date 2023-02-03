class Solution {
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return helper(board,0);
    }

    static int helper(boolean[][] board, int r){
        if(r == board.length){
            return 1;
        }
        int count = 0;
        for(int c = 0; c < board.length; c++){
            if(isSafe(board, r, c)){
                board[r][c] = true;
                count+=helper(board, r+1);
                board[r][c] = false;
            }
        }
        return count;
    }

    static boolean isSafe(boolean[][] board, int r, int c){
        // for same column
        for (boolean[] booleans : board) {
            if (booleans[c])
                return false;

        // for diagonal left
            int left = Math.min(r,c);
        for(int i=1; i<=left; i++)
            if(board[r-i][c-i])
                return false;

        // for diagonal left
        int right = Math.min(r,board.length - c - 1);
        for(int i=1; i<=right; i++)
            if(board[r-i][c+i])
                return false;
        }
        return true;
    }
}