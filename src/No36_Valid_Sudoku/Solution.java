package No36_Valid_Sudoku;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * <p>
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * A partially filled sudoku which is valid.
 * <p>
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            boolean[] rowValid = new boolean[9];
            boolean[] columnValid = new boolean[9];
            boolean[] gridValid = new boolean[9];

            char currentChar;
            for (int j = 0; j < 9; j++) {

                /* 判断行是否合法 */
                currentChar = board[i][j];
                if (currentChar != '.' && rowValid[currentChar - '1']) {
                    return false;
                } else if (currentChar != '.' && !rowValid[currentChar - '1']) {
                    rowValid[currentChar - '1'] = true;
                }

                /* 判断列是否合法 */
                currentChar = board[j][i];
                if (board[j][i] != '.' && columnValid[currentChar - '1']) {
                    return false;
                } else if (board[j][i] != '.' && !columnValid[currentChar - '1']) {
                    columnValid[currentChar - '1'] = true;
                }

                /* 判断小九宫格是否合法 */
                currentChar = board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3];
                if (currentChar != '.' && gridValid[currentChar - '1']) {
                    return false;
                } else if (currentChar != '.' && !gridValid[currentChar - '1']) {
                    gridValid[currentChar - '1'] = true;
                }
            }


        }
        return true;


    }
}
