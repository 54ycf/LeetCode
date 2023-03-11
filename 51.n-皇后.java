import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start
class Solution {
    int n;
    boolean[] cols; // 记录列有哪些用过了
    boolean[] diag1; // 记录左上到右下的斜对角
    boolean[] diag2; // 记录左下到右上的斜对角
    List<List<String>> ans;

    /*
     * 总算是在全排列之后做出来了，但是很慢，代码有待加强
     */

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.cols = new boolean[n];
        this.ans = new ArrayList<>();
        this.diag1 = new boolean[2 * n];
        this.diag2 = new boolean[2 * n];
        dfs(0, new ArrayList<String>());
        return ans;
    }

    private void dfs(int r, List<String> line) {
        if (r == n) {
            ans.add(new ArrayList<>(line)); //这个地方是要拷贝
        }
        for (int i = 0; i < n; i++) {
            if (valid(r, i)) {
                cols[i] = true;
                diag1[n + i - r] = true;
                diag2[i + r] = true;
                String str = drawLine(i);
                line.add(str);
                dfs(r + 1, line);
                cols[i] = false;
                diag1[n + i - r] = false;
                diag2[i + r] = false;
                line.remove(str);
            }
        }
    }

    private boolean valid(int r, int c) {
        if (cols[c] == true || diag1[n + c - r] || diag2[r + c])
            return false;
        return true;
    }

    private String drawLine(int ind){
        StringBuffer res = new StringBuffer();
        for(int i=0; i<ind; ++i){
            res.append(".");
        }
        res.append("Q");
        for(int i = ind+1; i<n;++i){
            res.append(".");
        }
        return res.toString();
    }
}
// @lc code=end
