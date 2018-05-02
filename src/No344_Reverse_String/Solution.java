package No344_Reverse_String;

public class Solution {
    public String reverseString(String s) {
        char[] chs = s.toCharArray();
        int i = 0, j = chs.length - 1;
        while (i < j) {
            char temp = chs[i];
            chs[i++] = chs[j];
            chs[j--] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : chs) {
            sb.append(c);
        }
        return sb.toString();
    }
}
