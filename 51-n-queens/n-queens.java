import java.util.*;

class Solution {
    List<List<String>> result = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board)
            Arrays.fill(row, '.');
        
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2*n];
        boolean[] diag2 = new boolean[2*n];
        
        backtrack(0, board, col, diag1, diag2, n);
        return result;
    }
    
    private void backtrack(int row, char[][] board,
                           boolean[] col,
                           boolean[] diag1,
                           boolean[] diag2,
                           int n) {
        
        if (row == n) {
            result.add(construct(board));
            return;
        }
        
        for (int c = 0; c < n; c++) {
            if (col[c] || diag1[row + c] || diag2[row - c + n])
                continue;
            
            board[row][c] = 'Q';
            col[c] = diag1[row + c] = diag2[row - c + n] = true;
            
            backtrack(row + 1, board, col, diag1, diag2, n);
            
            board[row][c] = '.';
            col[c] = diag1[row + c] = diag2[row - c + n] = false;
        }
    }
    
    private List<String> construct(char[][] board) {
        List<String> temp = new ArrayList<>();
        for (char[] row : board)
            temp.add(new String(row));
        return temp;
    }
}