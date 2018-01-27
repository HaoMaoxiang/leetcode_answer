package No54_Spiral_Matrix;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * For example,
 * Given the following matrix:
 * <p>
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new LinkedList<>();
        int m = matrix.length;
        if (m == 0) {
            return result;
        }
        int n = matrix[0].length;
        int rowStart = 0, rowEnd = m - 1;
        int colStart = 0, colEnd = n - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            if (rowStart == rowEnd) {   //如果只有一行，直接加入结果集中
                for (int i = colStart; i <= colEnd; i++) {
                    result.add(matrix[rowStart][i]);
                }
                break;
            }

            if (colStart == colEnd) {   //如果只有一列，直接加入结果集中
                for (int i = rowStart; i <= rowEnd; i++) {
                    result.add(matrix[i][colStart]);
                }
                break;
            }
            int rowTemp = rowStart;
            int colTemp = colStart;
            while (colTemp < colEnd) {  //从左到右
                result.add(matrix[rowTemp][colTemp]);
                colTemp += 1;
            }
            while (rowTemp < rowEnd) {  //从上到下
                result.add(matrix[rowTemp][colTemp]);
                rowTemp += 1;
            }
            while (colTemp > colStart) {    //从右到左
                result.add(matrix[rowTemp][colTemp]);
                colTemp -= 1;

            }
            while (rowTemp > rowStart) {    //从下到上
                result.add(matrix[rowTemp][colTemp]);
                rowTemp -= 1;
            }
            rowStart += 1;
            rowEnd -= 1;
            colStart += 1;
            colEnd -= 1;
        }
        return result;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = new int[][]{{1,2},{3,4}};
        System.out.println(s.spiralOrder(matrix));
    }
}
