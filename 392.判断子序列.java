/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i=0, j=0;
        while(i<n && j<m){
            if(s.charAt(i) == t.charAt(j)){ //it's crucial
                ++i;
            }
            ++j;
        }
        return i == n;
    }
}
// @lc code=end

