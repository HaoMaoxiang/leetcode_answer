package No118_Pascals_Triangle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * For example, given numRows = 5,
 * Return
 * <p>
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new LinkedList<>();
            if (i == 0) {
                row.add(1);
            } else {
                row.add(1); row.add(1);
                for (int j = 1; j < i; j++) {
                    List<Integer> preRow = result.get(i-1);
                    row.add(j, preRow.get(j-1) + preRow.get(j));
                }
            }
            result.add(row);

        }
        return result;
    }
}
