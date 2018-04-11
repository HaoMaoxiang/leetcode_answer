package No120_Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个三角形（数据数组），找出从上往下的最小路径和。每一步只能移动到下一行中的相邻结点上。
 * <p>
 * 比如，给你如下三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * <p>
 * 则从上至下最小路径和为 11（即，2 + 3 + 5 + 1 = 11）
 * <p>
 * 注意：
 * <p>
 * 加分项：如果你可以只使用 O(n) 的额外空间（n是三角形的行数）。
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle ==null || triangle.size() == 0) {
            return 0;
        }
        int[] res = new int[triangle.size()];
        for (List<Integer> nums : triangle) {
            for (int i = nums.size() - 1; i >= 0; i--) {
                if (i == 0) {
                    res[i] = res[i] + nums.get(i);
                } else if (i == nums.size() - 1) {
                    res[i] = res[i - 1] + nums.get(i);
                } else {
                    res[i] = Math.min(res[i - 1], res[i]) + nums.get(i);
                }
            }
//            System.out.println(Arrays.toString(res));
        }
        int min = Integer.MAX_VALUE;
        for (int num : res) {
            if (num < min) min = num;
        }
        return min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        triangle.add(new ArrayList<>(list));
        list.clear();
        list.add(3);
        list.add(4);
        triangle.add(new ArrayList<>(list));
        list.clear();
        list.add(6);
        list.add(5);
        list.add(7);
        triangle.add(new ArrayList<>(list));
        list.clear();
        list.add(4);
        list.add(1);
        list.add(8);
        list.add(3);
        triangle.add(new ArrayList<>(list));
        System.out.println(s.minimumTotal(triangle));
    }
}
