package No80_Remove_Duplicates_from_Sorted_Array_II;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * <p>
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int result = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                nums[result++] = nums[i];
            } else if (nums[i-1] == nums[i]) {
                if (!flag) {
                    nums[result++] = nums[i];
                    flag = true;
                }
            } else {
                nums[result++] = nums[i];
                flag = false;
            }
        }
        return result;
    }
}
