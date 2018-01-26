package No46_Permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 * <p>
 * For example,
 * [1,2,3] have the following permutations:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        int[] visited;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> one = new ArrayList<>(nums.length);
            visited = new int[nums.length];
            visited[i] = 1;
            one.add(nums[i]);
            helper(nums, result, one, visited);
        }

        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, List<Integer> one, int[] visited) {
        if (one.size() == nums.length) {
            result.add(new ArrayList<>(one));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            } else {
                one.add(nums[i]);
                visited[i] = 1;
                helper(nums, result, one, visited);
            }
            one.remove(one.size() - 1);
            visited[i] = 0;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.permute(new int[] {1,2,3}));
    }
}
