package No75_Sort_Colors;

import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 */
public class Solution {
    public void sortColors(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end && nums[start] == 0) start += 1;
        while (start < end && nums[end] == 2) end -= 1;
        int i = start;
        while (i <= end) {
            if (start <= end && nums[i] == 0) {
                swap(nums, start, i);
                start += 1;
            } else if (start <= end && nums[i] == 2) {
                swap(nums, end, i);
                i -= 1;
                end -= 1;
            }
            i += 1;
        }
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{2,1,0};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
