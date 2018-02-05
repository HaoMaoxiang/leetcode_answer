package No77_Combinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * For example,
 * If n = 4 and k = 2, a solution is:
 * <p>
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Solution {

    // Time Limit Exceeded
    public List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        if (k > n || k <= 0) {
            return result;
        }
        for (int i = 1; i <= n; i++) {
            List<Integer> one = new LinkedList<>();
            one.add(i);
            result.add(one);
        }

        for (int i = 1; i < k; i++) {
            List<List<Integer>> temp = result;
            result = new LinkedList<>();
            for (List<Integer> one : temp) {
                int lastNum = one.get(i - 1);
                if (lastNum < n) {
                    for (int j = lastNum + 1; j <= n; j++) {
                        List<Integer> o = new LinkedList<>(one);
                        o.add(j);
                        result.add(o);
                    }
                }
            }
        }

        return result;
    }

    // 回溯法
    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> item = new ArrayList<>(k);
        helper(n, k, 1, item, result);

        return result;
    }

    private void helper(int n, int k, int start, List<Integer> item, List<List<Integer>> result) {
        if (item.size() == k) {
            result.add(new ArrayList<>(item));
            return;
        }
        for (int i = start; i <= n; i++) {
            item.add(i);
            helper(n, k, i + 1, item, result);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combine2(20,16));
    }
}
