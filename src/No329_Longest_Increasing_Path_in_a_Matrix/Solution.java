package No329_Longest_Increasing_Path_in_a_Matrix;

/**
 * Given an integer matrix, find the length of the longest increasing path.
 * <p>
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 * <p>
 * Example 1:
 * <p>
 * nums = [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * Return 4
 * The longest increasing path is [1, 2, 6, 9].
 * <p>
 * Example 2:
 * <p>
 * nums = [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * Return 4
 * The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int res = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.max(dfs(matrix, dp, i, j, Integer.MIN_VALUE), res);
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int[][] dp, int row, int col, int preNum) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
            return 0;
        }
        if (matrix[row][col] <= preNum) return 0;
        if (dp[row][col] != 0) return dp[row][col];
        dp[row][col] = max(dfs(matrix, dp, row + 1, col, matrix[row][col]),
                dfs(matrix, dp, row - 1, col, matrix[row][col]),
                dfs(matrix, dp, row, col + 1, matrix[row][col]),
                dfs(matrix, dp, row, col - 1, matrix[row][col])) + 1;
        return dp[row][col];
    }

    private int max(int... nums) {
        int max = nums[0];
        for (int num : nums) {
            max = max < num ? num : max;
        }
        return max;
    }
}
