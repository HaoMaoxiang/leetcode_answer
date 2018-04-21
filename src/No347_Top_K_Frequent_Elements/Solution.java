package No347_Top_K_Frequent_Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 例如，
 * <p>
 * 给定数组 [1,1,1,2,2,3] , 和 k = 2，返回 [1,2]。
 * <p>
 * 注意：
 * <p>
 * 你可以假设给定的 k 总是合理的，1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            int count = map.get(key);
            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(key);
        }

        for (int i = nums.length; i >= 0 && k > 0; i--) {
            if (bucket[i] != null) {
                for (int e : bucket[i]) {
                    res.add(e);
                    k -= 1;
                }
            }
        }
        return res;

    }
}
