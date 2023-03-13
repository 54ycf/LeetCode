/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    /*
     * 思路不难，难在写简单，这里关键是要用两个指针，如果指针小于0就返回0，表示补0
     * 否则就是返回下标相加
     * 最后反转
     */
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int v1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int v2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int v = (v1 + v2 + carry) % 10;
            carry = (v1 + v2 + carry) / 10;
            res.append(v);
            --i;
            --j;
        }
        res.reverse();
        return res.toString();
    }
}
// @lc code=end
