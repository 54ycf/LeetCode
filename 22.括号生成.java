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
     "(" + 【i=p时所有括号的排列组合】 + ")" + 【i=q时所有括号的排列组合】
     但是太慢了，时间复杂度太高
     */ 
    private List<String>[] res;

    public List<String> generateParenthesis(int n) {
        res = new List[n+1];
        res[0] = new ArrayList<String>(100);
        res[0].add("");
        for (int i = 1; i <= n; i++) {
            res[i] = new ArrayList<String>();
            for (int j = 0; j < i; j++) {
                handle(i, j);
            }
        }
        return res[n];
    }

    public void handle(int n, int p) {
        int q = n - p - 1;
        res[p].forEach(ip ->{
            res[q].forEach(iq -> {
                res[n].add("(" + ip + ")" + iq);
            });
        });
    }

}
// @lc code=end
