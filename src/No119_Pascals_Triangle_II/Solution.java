package No119_Pascals_Triangle_II;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * <p>
 * For example, given k = 3,
 * Return [1,3,3,1].
 * <p>
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {

        int[] preRow;
        int[] row = new int[0];

        for (int i = 0; i <= rowIndex; i++) {
            preRow = row;
            row = new int[i + 1];
            row[0] = 1;
            for (int j = 1; j < i; j++) {
                row[j] = preRow[j-1] + preRow[j];
            }
            row[i] = 1;
        }

        List<Integer> result = new ArrayList<>();
        for (int i : row) {
            result.add(i);
        }
        return result;
    }
}
