package No220_Contains_Duplicate_III;

import java.util.TreeSet;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (set.floor(n) != null) {
                return n <= (set.floor(n) + t);
            } else if (set.ceiling(n) != null) {
                return n <= (set.ceiling(n) - t);
            }
//            if ((set.floor(n) != null && n <= set.floor(n) + t) || (set.ceiling(n) != null && n >= set.ceiling(n) + t)) {
//                return true;
//            }
            set.add(n);
            if (i > k) set.remove(nums[i - k]);
        }
        return false;
    }
}
