import java.util.Stack;

/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉 K 位数字
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stk = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (!stk.isEmpty() && c < stk.getLast() && k > 0) {
                stk.pollLast();
                k--;
            }
            stk.addLast(c);
        }
        String res = stk.stream().map(Object::toString).collect(Collectors.joining());
        res = res.substring(0, res.length() - k).replaceAll("^0+", "");
        return res.isEmpty() ? "0" : res;
    }
}
// @lc code=end

