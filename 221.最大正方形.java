/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    //关键是dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])
    public int maximalSquare(char[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] dp = new int[height][width];
        int maxSide = 0;
        for(int i=0; i<width; ++i){
            dp[0][i] = matrix[0][i]-'0';
            if(dp[0][i]==1) maxSide = 1;
        }
        for (int i = 0; i < height; i++) {
            dp[i][0] = matrix[i][0]-'0';
            if(dp[i][0]==1) maxSide = 1;
        }
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide*maxSide;
    }
}
// @lc code=end

