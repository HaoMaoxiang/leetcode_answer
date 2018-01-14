package No48_Rotate_Image;

import java.util.Arrays;

public class Solution {
    /*
     * 从外到内一圈圈模拟
     * matrix[i][j]->matrix[j][n-1-i]->matrix[n-1-i][n-1-j]->matrix[n-1-j][i]->matrix[i][j]
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp = matrix[j][n-i-1];
                matrix[j][n-i-1] = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = temp;
            }
        }
    }

    /*
     * 先沿主对角线反转，然后再沿垂直中线反转
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {   //沿主对角线翻转
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {   //沿垂直中线翻转
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n -1 -j];
                matrix[i][n-1-j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
