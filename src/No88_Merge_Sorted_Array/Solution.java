package No88_Merge_Sorted_Array;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int k = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                nums1[k--] = nums2[j--];
            } else if (j < 0) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
            }
        }

        System.out.println(Arrays.toString(nums1));

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = new int[]{1,3,4,0};
        int[] nums2 = new int[]{2};
        s.merge(nums1, 3, nums2, 1);
    }
}
