class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return helper(board, 0);
    }
    static List<List<String>> helper(boolean[][] board, int r){
        if(r == board.length){
            List<List<String>> ans = new ArrayList<>();
            List<String> sol = new ArrayList<>();
            for(boolean[] i: board){
                String s = "";
                for(boolean j: i){
                    if(j)
                        s = s+"Q";
                    else s = s+".";
                }
                sol.add(s);
            }
            ans.add(sol);
            return ans;
        }
        List<List<String>> curAns = new ArrayList<>();
        for(int col = 0; col < board.length; col++){
            if(isSafe(board, r, col)){
                board[r][col] = true;
                curAns.addAll(helper(board, r+1));
                board[r][col] = false;
            }
        }
        return curAns;
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