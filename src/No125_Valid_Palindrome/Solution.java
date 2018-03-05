package No125_Valid_Palindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            while (start < end && isValid(s.charAt(start))) start += 1;
            while (start < end && isValid(s.charAt(end))) end -= 1;
            if (Character.toUpperCase(s.charAt(start)) != Character.toUpperCase(s.charAt(end))) return false;
            start += 1; end -= 1;
        }
        return true;
    }

    private boolean isValid(char c) {
        return (c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9');
    }
}
