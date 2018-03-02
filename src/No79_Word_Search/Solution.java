package No79_Word_Search;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * For example,
 * Given board =
 * <p>
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int index, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }
        if (index == word.length()-1) return true;
        board[row][col] ^= 256;
        boolean flag = exist(board, word, index + 1, row - 1, col) ||
                exist(board, word, index + 1, row + 1, col) ||
                exist(board, word, index + 1, row, col - 1) ||
                exist(board, word, index + 1, row, col + 1);
        board[row][col] ^= 256;
        return flag;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        Solution s = new Solution();
        s.exist(board, "ABCCED");
    }
}
