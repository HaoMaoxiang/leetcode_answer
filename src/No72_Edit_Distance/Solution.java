package No72_Edit_Distance;

/**
 * 给出两个单词 word1 和 word2，找出将 word1 转换成 word2 所使用的最少的步骤数 (每个操作记为一步)。
 * <p>
 * 你可以对一个单词进行以下三种操作：
 * <p>
 * a) 插入一个字符
 * b) 删除一个字符
 * c) 替换一个字符
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int temp = (word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1);
                dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + temp);
            }
        }
        return dp[m][n];
    }

    private int min(int... nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (min > num) min = num;
        }
        return min;
    }
}
