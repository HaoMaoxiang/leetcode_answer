package No66_Plus_One;

import java.util.Arrays;

/**
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * <p>
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] result = new int[len+1];
        int carry = 1;
        for (int i = len - 1; i >=0; i--) {
            int digit = digits[i] + carry;
            if (digit == 10) {
                result[i+1] = 0;
                carry = 1;
            } else {
                result[i+1] = digit;
                carry = 0;
            }
        }
        if (carry == 1) {
            result[0] = 1;
            return result;
        } else {
            return Arrays.copyOfRange(result, 1, len + 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.plusOne(new int[]{0})));
    }
}
