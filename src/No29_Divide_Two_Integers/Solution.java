package No29_Divide_Two_Integers;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * <p>
 * If it is overflow, return MAX_INT.
 */
public class Solution {

    public int divide(int dividend, int divisor) {
        int result = 0;
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) {
            return 1;
        }
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE) {
            result += 1;
            dividend = dividend + Math.abs(divisor);
        }
        boolean flag = true;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            flag = false;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend >= divisor) {
            int shiftNum = 0;
            while (dividend >= divisor << shiftNum && (divisor << shiftNum > 0)) {
                shiftNum += 1;
            }
            result += 1 << (shiftNum - 1);
            dividend -= divisor << (shiftNum - 1);
        }
        return flag ? result : -result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(-2147483648, 1262480350));
    }
}
