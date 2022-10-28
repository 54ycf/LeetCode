import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ps = 0; //pointer of s
        int result = 0;
        for(int gi : g){
            while(ps<s.length && s[ps] < gi){
                ++ps;
            }
            if(ps<s.length){
                ++result;
                ++ps;
            }
        }
        return result;
    }
}
// @lc code=end

