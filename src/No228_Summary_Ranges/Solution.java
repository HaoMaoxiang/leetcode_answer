package No228_Summary_Ranges;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组，返回数组中区间范围的汇总。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 示例 2:
 * <p>
 * 输入: [0,2,3,4,6,8,9]
 * 输出: ["0","2->4","6","8->9"]
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int start = nums[0], end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] - end == 1) {
                end = nums[i];
            } else {
                if (start == end) {
                    res.add(start+"");
                } else {
                    res.add(start+"->"+end);
                }
                start = end = nums[i];
            }
        }
        if (start == end) {
            res.add(start+"");
        } else {
            res.add(start+"->"+end);
        }
        return res;
    }
}
