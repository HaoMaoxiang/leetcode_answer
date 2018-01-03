package No16_3Sum_Closest;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            System.exit(-1);
        }
        Arrays.sort(nums);
        int closestTarget = nums[0] + nums[1] + nums[2];
        int flag = Math.abs(closestTarget - target);
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                int newFlag = Math.abs(sum - target);
                if (flag > newFlag) {
                    flag = newFlag;
                    closestTarget = sum;
                }
                if (sum < target) {
                    start += 1;
                } else {
                    end -= 1;
                }
            }
        }
        return closestTarget;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.threeSumClosest(new int[]{1,2,4,8,16,32,64,128}, 82));
    }

}
