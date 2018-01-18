package No40_Combination_Sum_II;

import java.util.*;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * Each number in C may only be used once in the combination.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> out = new LinkedList<>();
        helper(candidates, target, 0, out, result);
        return new ArrayList<>(result);
    }

    private void helper(int[] candidates, int target, int index, List<Integer> out, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(out));
        } else {
            for (int i = index; i < candidates.length && target >= candidates[i]; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                out.add(candidates[i]);
                helper(candidates, target - candidates[i], i + 1, out, result);
                out.remove(out.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(s.combinationSum2(candidates, target));
    }
}
