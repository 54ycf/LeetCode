import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    /*
     * 写一个pair的哈希map，以简化if判断
     */
    public boolean isValid(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> pairs = new HashMap<>() {
            {
                put(']', '[');
                put(')', '(');
                put('}', '{');
            }
        };

        for (int i = 0; i < len; i++) {
            Character ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || !stack.pop().equals(pairs.get(ch)))
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end
