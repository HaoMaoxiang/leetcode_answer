package No41_First_Missing_Positive;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * <p>
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * <p>
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class Solution {

    public int firstMissingPositive1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
                i--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return nums.length + 1;
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int result = 0;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            while (start < end && nums[end] <= 0) {
                end -= 1;
            }
            while (start < end && nums[start] > 0) {
                start += 1;
            }
            if (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }

        if (nums[0] <= 0) {
            return 1;
        }

        for (int i = 0; i <= end; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (index <= end) {
                nums[index] = -Math.abs(nums[index]);
            }
        }
        for (; result <= end; result++) {
            if (nums[result] > 0)
                break;
        }
        return result+1;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.firstMissingPositive(new int[]{0}));
    }
}
