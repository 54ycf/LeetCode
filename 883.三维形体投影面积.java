/*
 * @lc app=leetcode.cn id=883 lang=java
 *
 * [883] 三维形体投影面积
 */

// @lc code=start
class Solution {
    public int projectionArea(int[][] grid) {
        int x=0,y=0,z=0;
        int[] rowMaxArr = new int[grid[0].length];
        for(int[] line : grid){
            int xMax = 0;
            for(int i=0; i<line.length; ++i){
                if(line[i]!=0)++z;
                xMax = xMax > line[i] ? xMax : line[i];
                rowMaxArr[i] = rowMaxArr[i] > line[i] ? rowMaxArr[i] : line[i];
            }
            x += xMax;
        }
        for (int i : rowMaxArr) {
            y += i;
        }
        return x + y + z;
    }
}
// @lc code=end

