package No300_Longest_Increasing_Subsequence;

import java.util.Arrays;

/**
 * 给出一个无序的整形数组，找到最长上升子序列的长度。
 * <p>
 * 例如，
 * <p>
 * 给出 [10, 9, 2, 5, 3, 7, 101, 18]，
 * 最长的上升子序列是 [2, 3, 7, 101]，因此它的长度是4。因为可能会有超过一种的最长上升子序列的组合，因此你只需要输出对应的长度即可。
 * <p>
 * 你的算法的时间复杂度应该在 O(n2) 之内。
 * <p>
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        if (nums == null || nums.length <= 0) return max;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
