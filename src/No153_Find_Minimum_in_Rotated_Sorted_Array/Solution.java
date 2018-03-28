package No153_Find_Minimum_in_Rotated_Sorted_Array;

/**
 * 假设一个按照升序排列的有序数组从某未知的位置旋转。
 * <p>
 * （比如 0 1 2 4 5 6 7 可能变成 4 5 6 7 0 1 2）。
 * <p>
 * 找到其中最小的元素。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 */
public class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        int mid = 0;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            }
        }
        return nums[start];
    }
}
