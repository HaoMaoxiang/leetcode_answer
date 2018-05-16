package No289_Game_Of_Life;

/**
 * 根据百度百科，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在1970年发明的细胞自动机。
 * <p>
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞具有一个初始状态 live（1）即为活细胞， 或 dead（0）即为死细胞。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * <p>
 * 1. 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * <p>
 * 2. 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * <p>
 * 3. 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * <p>
 * 4. 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * <p>
 * 根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。
 * <p>
 * 进阶:
 * <p>
 * 你可以使用原地算法解题吗？请记住，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值更新其他格子。
 * 在此题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 */
class Solution {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int num = numOfLive(board, i, j);
                if (board[i][j] == 1 && (num > 3 || num < 2)) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && num == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
                if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private int numOfLive(int[][] board, int i, int j) {
        int num = 0;
        for (int m = i - 1; m <= i + 1; m++) {
            for (int n = j - 1; n <= j + 1; n++) {
                if ((m != i || n != j) && m >= 0 && m < board.length && n >= 0 && n < board[0].length &&
                        (board[m][n] == 1 || board[m][n] == 3)) {
                    num += 1;
                }
            }
        }
        return num;
    }
}
