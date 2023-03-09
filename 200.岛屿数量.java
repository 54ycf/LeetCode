/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    int height;
    int width;

    public int numIslands(char[][] grid) {
        height = grid.length;
        width = grid[0].length;
        int nums = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    nums++;
                }
            }
        }
        return nums;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (isNotInArea(i, j)) {
            return;
        }
        if (grid[i][j] != '1') { // 0海洋 1未走过的大陆 2走过的大陆
            return;
        }
        grid[i][j] = '2';
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);

    }

    private boolean isNotInArea(int i, int j) {
        if (i < 0 || j < 0 || i == height || j == width) {
            return true;
        }
        return false;
    }
}
// @lc code=end
