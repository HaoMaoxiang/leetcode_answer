package No611_Valid_Triangle_Number;

import java.util.Arrays;

public class Solution {
    public int triangleNumber(int[] nums) {
        int res = 0;
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = nums.length -1; i >= 2; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    res += right - left;
                    right -= 1;
                } else {
                    left += 1;
                }
            }
        }
        return res;
    }
}
