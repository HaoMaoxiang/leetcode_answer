package No18_4Sum;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note: The solution set must not contain duplicate quadruplets.
 * <p>
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new LinkedList<>();

        //排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) { //第一个加数
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = nums.length - 1; j > i + 2; j--) { //第四个加数
                if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    continue;
                }

                int n = target - nums[i] - nums[j];
                int start = i + 1;  //第二个加数
                int end = j - 1;    //第三个加数
                while (start < end) {
                    if (nums[start] + nums[end] == n) {
                        List<Integer> one = new ArrayList<>(4);
                        one.add(nums[i]);
                        one.add(nums[start]);
                        one.add(nums[end]);
                        one.add(nums[j]);
                        result.add(one);
                        do {
                            start += 1;
                        } while (start < end && nums[start] == nums[start - 1]);
                        do {
                            end -= 1;
                        } while (start < end && nums[end] == nums[end + 1]);
                    } else if (nums[start] + nums[end] < n) {
                        do {
                            start += 1;
                        } while (start < end && nums[start] == nums[start - 1]);
                    } else {
                        do {
                            end -= 1;
                        } while (start < end && nums[end] == nums[end + 1]);
                    }
                }
            }
        }

        return result;

        /**
         //对任意两个求和
         Map<Set<Integer>, Integer> map = new HashMap<>();
         for (int i = 0; i < nums.length; i++) {
         for (int j = i + 1; j < nums.length; j++) {
         Set<Integer> index = new HashSet<>();
         index.add(i); index.add(j);
         map.put(index, nums[i]+nums[j]);
         }
         }

         for (Map.Entry<Set<Integer>, Integer> entry : map.entrySet()) {
         int i = 0, j = nums.length - 1;
         while (i < j) {
         if (entry.getKey().contains(i)) {
         i += 1;
         continue;
         }
         if (entry.getKey().contains(j)) {
         j -= 1;
         continue;
         }
         if ((nums[i] + nums[j]) == (target - entry.getValue())) {
         List<Integer> one = new LinkedList<>();
         one.add(nums[i]);one.add(nums[j]);
         for (Integer index : entry.getKey()) {
         one.add(nums[index]);
         }
         one.sort(Integer::compareTo);
         result.add(one);
         i += 1;
         j -= 1;
         } else if ((nums[i] + nums[j]) < (target - entry.getValue())) {
         i += 1;
         } else {
         j -= 1;
         }
         }15
         }**/



    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
