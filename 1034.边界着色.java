/*
 * @lc app=leetcode.cn id=1034 lang=java
 *
 * [1034] 边界着色
 */

// @lc code=start
class Solution {
    int color;
    int startPoint;
    int[][] gridc;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        this.gridc = grid.clone();
        this.color = color;
        this.startPoint = grid[row][col];

        search(grid, row, col, 0);
        return gridc;
    }

    private void search(int[][] grid, int r, int c, int direction){
        if(r==-1 || c==-1 || r==grid.length || c==grid[0].length) return;
        if(grid[r][c] == startPoint){
            if(r==0 || r==grid.length-1 || c==0 || c==grid[0].length-1 || grid[r-1][c]!=startPoint || grid[r+1][c]!=startPoint || grid[r][c-1]!=startPoint || grid[r][c+1]!=startPoint){
                gridc[r][c] = color;
            }
            if(direction!=2) search(grid, r+1, c, 1);
            if(direction!=1) search(grid, r-1, c, 2);
            if(direction!=4) search(grid, r, c+1, 3);
            if(direction!=3) search(grid, r, c-1, 4);
        }
    }
}
// @lc code=end

