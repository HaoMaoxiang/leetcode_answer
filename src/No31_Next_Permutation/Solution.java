package No31_Next_Permutation;

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p>
 * The replacement must be in-place, do not allocate extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Solution {

    public void nextPermutation(int[] nums) {
        int index = nums.length - 1;
        while(index > 0 && nums[index] <= nums[index - 1]) {
            index -= 1;
        }

        if (index == 0) {
            Arrays.sort(nums);
        } else {
            int minNumIndex = minNumLargerThanTarget(nums, index, nums[index-1]);
            int temp = nums[minNumIndex];
            nums[minNumIndex] = nums[index - 1];
            nums[index - 1] = temp;
            Arrays.sort(nums, index, nums.length);
        }
    }

    private int minNumLargerThanTarget(int[] nums, int index, int target) {
        int result = index;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] > target && nums[i] < nums[result]) {
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[] {1, 3, 2};
        s.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }


}
