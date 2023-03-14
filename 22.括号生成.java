import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {

    /*
     * "(" + 【i=p时所有括号的排列组合】 + ")" + 【i=q时所有括号的排列组合】
     * 但是太慢了，时间复杂度太高
     * 
     * dfs思路https://leetcode.cn/problems/generate-parentheses/solution/hui-su-suan-
     * fa-by-liweiwei1419/
     */
    private List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs("", 0, 0, n);
        return res;
    }

    //记录了左边的和右边的括号用了几个，最后要用n个
    private void dfs(String cur, int left, int right, int n) {
        if (left == n && right == n) {
            res.add(cur);
            return;
        }
        if (left < right) //右边多了，不符合
            return;
        if (left < n) {
            dfs(cur + "(", left + 1, right, n);
        }
        if (right < n) {
            dfs(cur + ")", left, right + 1, n);
        }
    }

}
// @lc code=end
