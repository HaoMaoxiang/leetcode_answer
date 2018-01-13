package No53_Maximum_Subarray;

public class Solution {

    /* 非动态规划 */
    public int maxSubArray(int[] nums) {
        int largestSum = nums[0];
        int tempSum = 0;
        for (int i = 0; i < nums.length; i++) {
            tempSum += nums[i];
            largestSum = Math.max(largestSum, tempSum);
            if (tempSum < 0) {
                tempSum = 0;
            }
        }
        return largestSum;
    }

    /* 动态规划
     * d[i] = max{d[i-1]+nums[i], nums[i]}
     */
    public int maxSubArray2(int[] nums) {
        int largestSum = Integer.MIN_VALUE;
        int tempSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tempSum = Math.max(tempSum + nums[i], nums[i]);
            largestSum = Math.max(largestSum, tempSum);
        }

        return largestSum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxSubArray2(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
