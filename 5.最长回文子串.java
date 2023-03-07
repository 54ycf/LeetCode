/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    /*
     * DP s是回文(l,r)，则 若s_(l-1)=s_(r+1)，则(l-1,r+1)是回文
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;
        char[] charArr = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        int maxLen = 1; // 最长回文串长度
        int start = 0;
        int end = 0;
        for (int r = 1; r < len; ++r) {
            for (int l = 0; l < r; ++l) {
                if (charArr[l] == charArr[r] && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        start = l;
                        end = r;
                        maxLen = r - l + 1;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
// @lc code=end
