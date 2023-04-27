import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=980 lang=java
 *
 * [980] 不同路径 III
 */

// @lc code=start
class Solution {
    //注意审题！要走完所有的空白地方
    int startRow = -1;
    int startCol = -1;
    int res = 0;
    int rows;
    int cols;
    int[][] grid;
    boolean[][] visited;
    int zeroNum = 0;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j]==0){
                    zeroNum++;
                }else if(grid[i][j] == 1){
                    startRow = i;
                    startCol = j;
                }
            }
        }
        grid[startRow][startCol] = 0;
        zeroNum++;
        dfs(startRow, startCol,0);
        
        return res;
    }

    void dfs(int r, int c, int gone){
        if(r==-1||c==-1||r==rows||c==cols) return;//越界
        if(grid[r][c]==-1 || visited[r][c]) return;//不可走
        if(grid[r][c]==2){ //目的地
            if(gone==zeroNum)
                res++;
            return;
        }
        if(grid[r][c]==0){
            visited[r][c] = true;
            gone++;
            dfs(r+1,c,gone);
            dfs(r,c+1,gone);
            dfs(r-1,c,gone);
            dfs(r,c-1,gone);
            visited[r][c] = false;
            return;
        }
        
    }
}
// @lc code=end

