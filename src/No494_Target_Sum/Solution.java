package No494_Target_Sum;

public class Solution {

    /* 深度优先搜索 */
    public int findTargetSumWays1(int[] nums, int S) {
        return dfs(nums, 0, 0, S);
    }

    private int dfs(int[] nums, int start, int sum, int S) {
        if (start == nums.length) {
            if (sum == S) return 1;
            else return 0;
        }
        return dfs(nums, start + 1, sum + nums[start], S) + dfs(nums, start + 1, sum - nums[start], S);
    }

    /**
     * 动态规划
     * sum(正) - sum(负) = target
     * sum(正) - sum(负) + sum(正) + sum(负) = target + sum
     * sum(正) = (target + sum) / 2
     * 转化为在集合中找到和等于(target + sum) / 2的子集的个数
     */
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum < S || (S + sum) % 2 > 0 ? 0 : helper(nums, (S + sum) / 2);
    }

    private int helper(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
