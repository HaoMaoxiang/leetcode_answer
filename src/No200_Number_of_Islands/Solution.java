package No200_Number_of_Islands;

/**
 * 给定 '1'（陆地）和 '0'（水）的二维网格图，计算岛屿的数量。一个岛被水包围，并且通过水平或垂直连接相邻的陆地而形成。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 11110
 * 11010
 * 11000
 * 00000
 * 答案: 1
 * <p>
 * 示例 2:
 * <p>
 * 11000
 * 11000
 * 00100
 * 00011
 * 答案: 3
 */
public class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return result;
        }
        int m = grid.length, n = grid[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    result += 1;
                    helper(grid, i, j, visited);
                }
            }
        }
        return result;
    }

    private void helper(char[][] grid, int row, int col, int[][] visited) {
        if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0 || grid[row][col] == '0' || visited[row][col] == 1) return;
        visited[row][col] = 1;
        helper(grid, row + 1, col, visited);
        helper(grid, row - 1, col, visited);
        helper(grid, row, col + 1, visited);
        helper(grid, row, col - 1, visited);
    }
}
