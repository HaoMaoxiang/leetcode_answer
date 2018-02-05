package No74_Search_a_2D_Matrix;

import java.util.List;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        return helper(matrix, target, 0, m-1, 0, n-1);
    }

    private boolean helper(int[][] matrix, int target, int rowStart, int rowEnd, int colStart, int colEnd) {
        if (colStart > colEnd || rowEnd < rowStart) {
            return false;
        }
        if (matrix[rowEnd][colStart] == target) {
            return true;
        } else if (matrix[rowEnd][colStart] < target) {
            return helper(matrix, target, rowStart, rowEnd, colStart+1, colEnd);
        } else {
            return helper(matrix, target, rowStart, rowEnd-1, colStart, colEnd);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(s.searchMatrix(matrix,12));
    }

}
