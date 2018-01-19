package No34_Search_for_a_Range;

import java.util.Arrays;

/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
//        if (nums.length == 0) {
//            return new int[]{-1, -1};
//        }
        int[] result = new int[2];
        result[0] = Integer.MAX_VALUE;
        result[1] = Integer.MIN_VALUE;
        helper(nums, target, 0, nums.length - 1, result);
        if (result[0] == Integer.MAX_VALUE && result[1] == Integer.MIN_VALUE) {
            result[0] = -1;
            result[1] = -1;
        }
        return result;
    }

    private void helper(int[] nums, int target, int start, int end, int[] result) {
        int i = start, j = end;
        int mid = (i + j) / 2;
        if (end >= start) {
            if (nums[mid] == target) {
                result[0] = Math.min(result[0], mid);
                result[1] = Math.max(result[1], mid);
                helper(nums, target, start, mid - 1, result);
                helper(nums, target, mid + 1, end, result);
            } else if (nums[mid] > target) {
                helper(nums, target, start, mid - 1, result);
            } else {
                helper(nums, target, mid + 1, end, result);
            }
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.searchRange(new int[] {1}, 1)));
    }
}
