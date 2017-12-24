package No1_Two_Sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 */
class Solution {

    //两重循环,时间复杂度O(n^2), 空间复杂度O(1)
    /**
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }*/

    //使用Map,时间复杂度O(n), 空间复杂度O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i)
                return new int[] {map.get(complement), i};
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        Solution s = new Solution();
        System.out.printf(Arrays.toString(s.twoSum(nums, target)));
    }
}