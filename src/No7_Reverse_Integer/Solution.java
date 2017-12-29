package No7_Reverse_Integer;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Note：要注意的有两点，一点是符号，另一点是整数越界问题
 */
public class Solution {

    public int reverse(int x) {
        int result = 0;
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        int num = Math.abs(x);

        while (num != 0) {
            int temp = num % 10;
            if (result <= (Integer.MAX_VALUE - num % 10) / 10) {
                result = result * 10 + temp;
                num /= 10;
            } else {
                result = 0;
                break;
            }
        }
        return x > 0 ? result: -result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverse(1463847412));
    }
}
