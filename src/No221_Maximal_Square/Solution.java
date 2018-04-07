package No221_Maximal_Square;

/**
 * 在一个由0和1组成的二维矩阵内，寻找只包含1的最大正方形，并返回其面积。
 * <p>
 * 例如，给出如下矩阵：
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 返回 4.
 */
public class Solution {
    /*
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        //第一列赋值
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(max, dp[i][0]);
        }
        //第一行赋值
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] - '0';
            max = Math.max(max, dp[0][j]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                dp[i][j] = matrix[i][j] == '1' ? Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1 : 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
    */
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[] pre = new int[n];
        int[] cur = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = matrix[0][i] - '0';
            max = Math.max(max, pre[i]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    cur[j] = matrix[i][j] - '0';
                } else {
                    cur[j] = matrix[i][j] == '1' ? Math.min(pre[j], Math.min(pre[j - 1], cur[j - 1])) + 1 : 0;
                }
                max = Math.max(max, cur[j]);
            }
            pre = Arrays.copyOf(cur, n);
        }
        return max * max;
    }
}
