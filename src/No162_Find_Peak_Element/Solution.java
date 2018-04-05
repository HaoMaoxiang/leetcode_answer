package No162_Find_Peak_Element;

/**
 * 峰值元素是指其值大于左右相邻值的元素。
 * <p>
 * 给定一个输入数组，其中 num[i] ≠ num[i+1]，找到峰值元素并返回其索引。
 * <p>
 * 数组可能包含多个峰值，在这种情况下，返回到任何一个峰值所在位置都可以。
 * <p>
 * 你可以想象得到  num[-1] = num[n] = -∞。
 * <p>
 * 例如，在数组 [1, 2, 3, 1]中 3 是峰值元素您的函数应该返回索引号2。
 * <p>
 * 注意:
 * <p>
 * 你的解决方案应该是对数复杂度的。
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (left == mid) return nums[left] < nums[right] ? right : left;
            left = nums[mid] < nums[mid + 1] ? mid : left;
            right = nums[mid] > nums[mid + 1] ? mid : right;
        }
        return 0;
    }
}
