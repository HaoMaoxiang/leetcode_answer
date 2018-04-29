package No334_Increasing_Triplet_Subsequence;

/**
 * 给定一个未排序的数组，请判断这个数组中是否存在长度为3的递增的子序列。
 * <p>
 * 正式的数学表达如下:
 * <p>
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 要求算法时间复杂度为O(n)，空间复杂度为O(1) 。
 * <p>
 * 示例:
 * 输入 [1, 2, 3, 4, 5],
 * 输出 true.
 * <p>
 * 输入 [5, 4, 3, 2, 1],
 * 输出 false.
 */
public class Solution {

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int min1 = nums[0];
        int min2 = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min2) {
                return true;
            }
            if (nums[i] > min1) {
                min2 = Math.min(min2, nums[i]);
            } else {
                min1 = Math.min(min1, nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.increasingTriplet(new int[]{9,8,7,6,5}));
    }
}
