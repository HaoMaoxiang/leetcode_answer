package No165_Compare_Version_Numbers;

/**
 * 比较两个版本号 version1 和 version2。
 * 如果 version1 大于 version2 返回 1，如果 version1 小于 version2 返回 -1， 除此以外 返回 0。
 * <p>
 * 您可能认为版本字符串非空，并且只包含数字和 . 字符。
 * <p>
 * 这个 . 字符不代表小数点，而是用于分隔数字序列。
 * <p>
 * 例如，2.5 不是“两个半”或“差一半到三个版本”，它是第二个第一级修订版本的第五个二级修订版本。
 * <p>
 * 以下是版本号排序的示例：
 * <p>
 * 0.1 < 1.1 < 1.2 < 13.37
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] vers1 = (version1+".").split("\\.");
        String[] vers2 = (version2+".").split("\\.");
        int s1 = vers1.length, s2 = vers2.length;
        int i = 0;
        while (i < s1 || i < s2) {
            int v1 = i < s1 ? Integer.parseInt(vers1[i]) : 0;
            int v2 = i < s2 ? Integer.parseInt(vers2[i]) : 0;
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
            i += 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.compareVersion("01.0", "1"));
    }
}
