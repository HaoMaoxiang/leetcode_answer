package No17_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * <p>
 * {2:"abc",3:"def",4:"ghi",5:"jkl",6:"mno",7:"pqrs",8:"tuv",9:"wxyz",0:" "}
 * <p>
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        String[] map = new String[] {" ", "", "abc", "def", "ghi", "jkl",
                                    "mno", "pqrs", "tuv", "wxyz"};
        if (digits == null || digits.length() == 0) {
            return result;
        }
        for (int i = 0; i < map[digits.charAt(0)-'0'].length(); i++) {
            result.add(map[digits.charAt(0)-'0'].charAt(i)+"");
        }

        for (int i = 1; i < digits.length(); i++) {
            result = cartesianProduct(result, map[digits.charAt(i)-'0']);
        }

        return result;
    }

    private List<String> cartesianProduct(List<String> list, String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < s.length(); j++) {
                result.add(list.get(i) + s.charAt(j));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.letterCombinations("23"));
    }
}


