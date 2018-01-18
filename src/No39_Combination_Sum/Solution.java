package No39_Combination_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [[7],[2, 2, 3]]
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> out = new LinkedList<>();
        helper(candidates, target, 0, out, result);
        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> out, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(out));
        } else {
            for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
                out.add(candidates[i]);
                helper(candidates, target - candidates[i], i, out, result);
                out.remove(out.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        System.out.println(s.combinationSum(candidates, target));
    }
}
