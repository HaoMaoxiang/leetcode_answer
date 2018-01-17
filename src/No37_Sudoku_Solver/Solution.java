package No37_Sudoku_Solver;

import java.util.Arrays;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * Empty cells are indicated by the character '.'.
 * [".",".","9","7","4","8",".",".","."]
 * ["7",".",".",".",".",".",".",".","."]
 * [".","2",".","1",".","9",".",".","."]
 * [".",".","7",".",".",".","2","4","."]
 * [".","6","4",".","1",".","5","9","."]
 * [".","9","8",".",".",".","3",".","."]
 * [".",".",".","8",".","3",".","2","."]
 * [".",".",".",".",".",".",".",".","6"]
 * [".",".",".","2","7","5","9",".","."]
 * <p>
 * You may assume that there will be only one unique solution.
 * ["5","1","9","7","4","8","6","3","2"]
 * ["7","8","3","6","5","2","4","1","9"]
 * ["4","2","6","1","3","9","8","7","5"]
 * ["3","5","7","9","8","6","2","4","1"]
 * ["2","6","4","3","1","7","5","9","8"]
 * ["1","9","8","5","2","4","3","6","7"]
 * ["9","7","5","8","6","3","1","2","4"]
 * ["8","3","2","4","9","1","7","5","6"]
 * ["6","4","1","2","7","5","9","8","3"]
 */
public class Solution {

    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return;
        helper(board, 0, 0);
    }

    private boolean helper(char[][] board, int i, int j) {
        if (j >= 9)
            return helper(board, i + 1, 0);
        if (i == 9) {
            return true;
        }
        if (board[i][j] == '.') {
            for (int k = 1; k <= 9; k++) {
                board[i][j] = (char) (k + '0');
                if (isValid(board, i, j) && helper(board, i, j + 1)) {
                    return true;
                }
                board[i][j] = '.';
            }
        } else {
            return helper(board, i, j + 1);
        }
        return false;
    }

    private boolean isValid(char[][] board, int i, int j) {
        for (int k = 0; k < 9; k++) {
            if (k != j && board[i][k] == board[i][j])
                return false;
        }
        for (int k = 0; k < 9; k++) {
            if (k != i && board[k][j] == board[i][j])
                return false;
        }
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
                if ((row != i || col != j) && board[row][col] == board[i][j])
                    return false;
            }
        }
        return true;
    }

    /**
     * '9', '1' '7', '6', '8', '2', '5', '4', '3'
     * '3', '5', '2', '1', '9', '4', '7', '6', '8'
     * '6', '8', '4', '5', '7', '3', '1', '9', '2'
     * '5', '9', '6', '4', '2', '8', '3', '1', '7'
     * '4', '2', '1', '7', '3', '6', '9', '8', '5'
     * '7', '3', '8', '9', '1', '5', '6', '2', '4'
     * '8', '7', '5', '2', '6', '1', '4', '3', '9'
     * '1', '4', '3', '8', '5', '9', '2', '7', '6'
     * '2', '6', '9', '3', '4', '7', '8', '5', '1'
     */
    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = new char[][]{
                {'.', '.', '7', '6', '8', '2', '5', '4', '3'},
                {'3', '5', '2', '1', '9', '4', '7', '6', '8'},
                {'6', '8', '4', '5', '7', '3', '1', '9', '2'},
                {'5', '9', '6', '4', '2', '8', '3', '1', '7'},
                {'4', '2', '1', '7', '3', '6', '9', '8', '5'},
                {'7', '3', '8', '9', '1', '5', '6', '2', '4'},
                {'8', '7', '5', '2', '6', '1', '4', '3', '9'},
                {'1', '4', '3', '8', '5', '9', '2', '7', '6'},
                {'2', '6', '9', '3', '4', '7', '8', '.', '1'}
        };
        s.solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }
}
