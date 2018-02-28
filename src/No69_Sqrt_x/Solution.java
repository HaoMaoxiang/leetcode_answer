package No69_Sqrt_x;

/**
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x.
 * <p>
 * x is guaranteed to be a non-negative integer.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 4
 * Output: 2
 * Example 2:
 * <p>
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncat
 */
public class Solution {
    public int mySqrt(int x) {
        if(x<=1) {
            return x;
        }

        int begin = 1;
        int end = x;
        int middle = 0;
        while(begin<=end) {
            middle = begin + (end - begin)/2;
            if(middle==x/middle) {
                return middle;
            } else {
                if (middle<x/middle) {
                    begin = middle + 1;
                } else {
                    end = middle - 1;
                }
            }

        }
        return end;
    }
}
