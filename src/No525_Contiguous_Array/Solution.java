package No525_Contiguous_Array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * 示例 2:
 * <p>
 * 输入: [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 * 注意: 给定的二进制数组的长度不会超过50000。
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        int res = 0;
        if (nums == null || nums.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int sum = nums[0] == 0 ? -1 : 1;
        map.put(0, -1);
        map.put(sum, 0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) sum -= 1;
            else sum += 1;
            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMaxLength(new int[]{0, 1}));
    }
}
