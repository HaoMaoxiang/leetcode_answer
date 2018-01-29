package No60_Permutation_Sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Note: Given n will be between 1 and 9 inclusive.
 */
public class Solution {
    // 使用nextPermutation方法求第k个排列
    public String getPermutation1(int n, int k) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i + 1;
        }

        for (int i = 1; i < k; i++) {
            nextPermutation(result);
        }

        return arr2str(result);
    }

    private void nextPermutation(int[] nums) {
        int index = nums.length - 1;
        while(index > 0 && nums[index] <= nums[index - 1]) {
            index -= 1;
        }

        if (index == 0) {
            Arrays.sort(nums);
        } else {
            int minNumIndex = minNumLargerThanTarget(nums, index, nums[index-1]);
            int temp = nums[minNumIndex];
            nums[minNumIndex] = nums[index - 1];
            nums[index - 1] = temp;
            Arrays.sort(nums, index, nums.length);
        }
    }

    private int minNumLargerThanTarget(int[] nums, int index, int target) {
        int result = index;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] > target && nums[i] < nums[result]) {
                result = i;
            }
        }
        return result;
    }

    private String arr2str(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
        }
        return sb.toString();
    }


    public String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();
        List<Integer> nums = new ArrayList<>(n);
        int pCount = 1;
        for (int i = 0; i < n; i++) {
            nums.add(i + 1);
            pCount *= (i + 1);
        }

        k--;
        while (true) {
            pCount = pCount / n;
            result.append(nums.remove(k / pCount));
            k %= pCount;
            if (--n == 0) {
                break;
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getPermutation(3,6));
    }
}
