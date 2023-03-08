import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    /*
     * 分成四个状态，每个状态的边界判定，并转移状态。最后结束是总量达标作为判断
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int rBoundary = matrix[0].length - 1;
        int lBoundary = 0;
        int tBoundary = 0;
        int bBoundary = matrix.length - 1;
        int i = 0, j = 0;
        byte direction = 0; // 右0 下1 左2 上3
        List<Integer> res = new ArrayList<>();
        int total = (rBoundary + 1) * (bBoundary + 1);
        int curNum = 0;
        while (true) {
            res.add(matrix[i][j]);
            switch (direction) {
                case 0: {
                    if (j < rBoundary) {
                        ++j;
                    } else {
                        ++i;
                        direction = 1;
                        tBoundary++;
                    }
                    break;
                }
                case 1: {
                    if (i < bBoundary) {
                        ++i;
                    } else {
                        --j;
                        direction = 2;
                        rBoundary--;
                    }
                    break;
                }
                case 2: {
                    if (j > lBoundary) {
                        --j;
                    } else {
                        --i;
                        direction = 3;
                        bBoundary--;
                    }
                    break;
                }
                case 3: {
                    if (i > tBoundary) {
                        --i;
                    } else {
                        ++j;
                        direction = 0;
                        lBoundary++;
                    }
                }
            }
            ++curNum;
            if (curNum == total)
                break;
        }
        return res;
    }
}
// @lc code=end
