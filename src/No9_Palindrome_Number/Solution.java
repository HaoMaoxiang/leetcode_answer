package No9_Palindrome_Number;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 两种思路：
 * <ol>
 *     <li>将输入整数转换成倒序的一个整数，再比较转换前后的两个数是否相等</li>
 *     <li>每次提取头尾两个数，判断它们是否相等，判断后去掉头尾两个数。</li>
 * </ol>
 */
public class Solution {

    //方法1 将输入整数反转
    public boolean isPalindrome1(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int reverseX = 0;
        int tempX = x;
        while (tempX != 0) {
            reverseX = reverseX * 10 + tempX % 10;
            tempX = tempX / 10;
        }
        return reverseX == x;
    }

    //方法2 每次提取头尾两个数，判断它们是否相等
    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        int len = 1;
        while (x / len >= 10) {
            len *= 10;
        }
        while (x != 0) {
            int left = x / len;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % len) / 10;
            len = len / 100;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome2(2112));
    }
}
