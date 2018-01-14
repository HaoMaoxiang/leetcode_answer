package No49_Group_Anagrams;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            int[] flag = new int[26];
            Arrays.fill(flag, 0);
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                flag[str.charAt(j)-'a'] = flag[str.charAt(j)-'a'] + 1;
            }
            List<String> temp = result.getOrDefault(Arrays.toString(flag), new LinkedList<>());
            temp.add(str);
            result.put(Arrays.toString(flag), temp);
        }
        return new ArrayList<>(result.values());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
