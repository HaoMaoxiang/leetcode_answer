package No47_Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        int[] visited;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }
            List<Integer> one = new ArrayList<>(nums.length);
            visited = new int[nums.length];
            one.add(nums[i]);
            visited[i] = 1;
            helper(nums, result, one, visited);
        }

        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, List<Integer> one, int[] visited) {
        if (one.size() == nums.length) {
            result.add(new ArrayList<>(one));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0) {
                if (i > 0 && nums[i-1] == nums[i] && visited[i - 1] == 0) {
                    continue;
                }
                one.add(nums[i]);
                visited[i] = 1;
                helper(nums, result, one, visited);
                one.remove(one.size() - 1);
                visited[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.permuteUnique(new int[]{1,1,2}));
    }

}
