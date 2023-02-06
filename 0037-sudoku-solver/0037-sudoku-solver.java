class Solution {
    public void solveSudoku(char[][] board) {
        sudokuSolver(board, 0, 0);
    }
    static boolean sudokuSolver(char[][] board, int r, int c){
        if(r==board.length - 1 && c==board[0].length) {
            if(isAllFilled(board))
                return true;
        }
        
        if(c==board[0].length){
            return sudokuSolver(board, r+1, 0);
        }
        
        if(board[r][c] == '.'){
            for(int i = 1; i <= 9; i++){
                if(isSafeNo(i,board,r,c)){
                    board[r][c]=(char) (i + '0');
                    if(sudokuSolver(board, r, c+1))
                        return true;
                    board[r][c]='.';
                }
            }
        }
        else return sudokuSolver(board, r, c + 1);
        return false;
    }

    static boolean isAllFilled(char[][] board){
        for(char[] b: board)
            for(char i: b){
                if(i=='.')
                    return false;
            }
        return true;
    }
    static boolean isSafeNo(int n, char[][] board, int r, int c){
        char ch = (char) (n + '0');
        // check in same row
        for(int col = 0; col < 9; col++ ){
            if(board[r][col] == ch)
                return false;
        }

        // check for same row
        for(int row = 0; row < 9; row++ ){
            if(board[row][c] == ch)
                return false;
        }

        // check for same box
        while(r%3 != 0)
            r--;
        while(c%3 != 0)
            c--;

        for(int i = r; i < r + 3; i++){
            for(int j = c; j < c + 3; j++){
                if(board[i][j] == ch)
                    return false;
            }
        }
        return true;
    }
}