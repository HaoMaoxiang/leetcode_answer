package No174_Dungeon_Game;

/**
 * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格布局。我们英勇的骑士（K）最初被安置在左上角的房间里，并且必须通过地下城对抗来拯救公主。
 * <p>
 * 骑士具有以正整数表示的初始健康点。如果他的健康点在任何时候降至 0 或以下，他会立即死亡。
 * <p>
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时失去健康点（负整数）；其他房间要么是空的（0），要么包含增加骑士身体健康的魔法球（正整数）。
 * <p>
 * 为了尽快到达公主，骑士决定只会每次向右或向下移动一步。
 * <p>
 * 写一个函数来确定骑士的最低初始健康点数，以便他能够拯救公主。
 * <p>
 * 例如，考虑到下面的地下城，如果骑士遵循最佳路径 RIGHT-> RIGHT -> DOWN -> DOWN，则骑士的初始健康必须至少为 7。
 * <p>
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 * <p>
 * 注意:
 * <p>
 * 骑士的健康点没有上限。
 * <p>
 * 任何房间都可能对骑士健康点造成威胁，也可能增加骑士的健康点，包括骑士进入的第一个房间和公主被监禁的右下角房间。
 */
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = Math.max(1 - dungeon[m-1][n-1], 1);
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n-1], 1);
        }
        for (int j = n -2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int left = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                int right = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                dp[i][j] = Math.min(left, right);
            }
        }

        return dp[0][0];
    }
}
