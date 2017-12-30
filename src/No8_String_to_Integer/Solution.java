package No8_String_to_Integer;

/**
 * Implement atoi to convert a string to an integer.
 */
public class Solution {

    public int myAtoi(String str) {
        // 1. 判断是否是空字符串
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        // 2. 标记正负号
        boolean positive = true;
        int i = 0;
        if (str.charAt(0) == '+') {
            i++;
        }
        if (str.charAt(0) == '-') {
            i++;
            positive = false;
        }

        double result = 0;
        for (; i < str.length(); i++) {
            if ((str.charAt(i)-'0' > 9)||(str.charAt(i)-'0' < 0)) {
                break;
            } else {
                result = result * 10 + str.charAt(i)-'0';
                if (positive && result > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (!positive && result - 1 > Integer.MAX_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
        }
        return positive ? (int) result : (int) -result;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myAtoi("-2147483648"));
    }
}
