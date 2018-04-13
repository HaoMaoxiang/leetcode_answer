package No357_Count_Numbers_With_Unique_Digits;

/**
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n。
 * <p>
 * 示例:
 * 给定 n = 2，返回 91。（答案应该是除[11,22,33,44,55,66,77,88,99]外，0 ≤ x < 100 间的所有数字）
 */
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {

        if (n == 0) return 1;
        if (n == 1) return 10;
        int res = 10;
        int temp = 9;
        for (int i = 2; i <= n; i++) {
            temp = temp * (10 - i + 1);
            res += temp;
        }
        return res;
    }

}
