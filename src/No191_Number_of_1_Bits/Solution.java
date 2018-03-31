package No191_Number_of_1_Bits;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            result += 1;
            n = n & (n - 1);
        }
        return result;
    }
}
