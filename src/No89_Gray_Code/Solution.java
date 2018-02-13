package No89_Gray_Code;

import java.util.LinkedList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * <p>
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * <p>
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * <p>
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * <p>
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * <p>
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        result.add(0);
        for (int i = 0; i < n; i++) {
            int size = result.size();
            for (int j = size - 1 ; j >= 0; j--) {
                result.add(result.get(j) + (1 << i));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.grayCode(2));
    }
}
