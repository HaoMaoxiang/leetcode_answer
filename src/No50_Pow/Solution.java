package No50_Pow;

/**
 * Implement pow(x, n).
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 * <p>
 * Input: 2.10000, 3
 * Output: 9.26100
 */
public class Solution {

    /* 迭代 */
    public double myPow(double x, int n) {
        long N = (long)n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double result = 1.0;
        while (N > 0) {
            if ((N & 1) == 1) {
                result *= x;
            }
            x *= x;
            N >>= 1;
        }
        return result;
    }


    /* 递归
    public double myPow(double x, int n) {

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        return helper(x, n);
    }

    private double helper(double x, int n) {
        if (n % 2 == 1) {

        }
    }*/
}
