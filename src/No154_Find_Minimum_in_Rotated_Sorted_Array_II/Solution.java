package No154_Find_Minimum_in_Rotated_Sorted_Array_II;

/**
 * 这是问题 “在旋转排序阵列中查找最小值” 的进阶版：
 * <p>
 * 如果允许重复，该怎么办？
 * <p>
 * 这会影响时间复杂度吗？会如何影响和为什么？
 * <p>
 * 假设一个按照升序排列的有序数组从某未知的位置旋转。
 * <p>
 * （比如 0 1 2 4 5 6 7 可能变成是 4 5 6 7 0 1 2）。
 * <p>
 * 找到其中最小的元素。
 * <p>
 * 数组中可能存在重复的元素。
 */
public class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right -= 1;
            }
        }
        return nums[left];
    }
}
