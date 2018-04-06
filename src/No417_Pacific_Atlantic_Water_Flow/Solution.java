package No417_Pacific_Atlantic_Water_Flow;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 * <p>
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 * <p>
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 * <p>
 * Note:
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 * Example:
 * <p>
 * Given the following 5x5 matrix:
 * <p>
 * Pacific ~   ~   ~   ~   ~
 * ~  1   2   2   3  (5) *
 * ~  3   2   3  (4) (4) *
 * ~  2   4  (5)  3   1  *
 * ~ (6) (7)  1   4   5  *
 * ~ (5)  1   1   2   4  *
 * *   *   *   * Atlantic
 * <p>
 * Return:
 * <p>
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */
public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, Integer.MIN_VALUE, pacific);
            dfs(matrix, i, n - 1, Integer.MIN_VALUE, atlantic);
        }
        for (int j = 0; j < n; j++) {
            dfs(matrix, 0, j, Integer.MIN_VALUE, pacific);
            dfs(matrix, m - 1, j, Integer.MIN_VALUE, atlantic);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, int row, int col, int pre, boolean[][] ocean) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length
                || matrix[row][col] < pre || ocean[row][col]) {
            return;
        }
        ocean[row][col] = true;
        dfs(matrix, row + 1, col, matrix[row][col], ocean);
        dfs(matrix, row - 1, col, matrix[row][col], ocean);
        dfs(matrix, row, col + 1, matrix[row][col], ocean);
        dfs(matrix, row, col - 1, matrix[row][col], ocean);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = new int[][] {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}};
        s.pacificAtlantic(matrix);
    }
}
