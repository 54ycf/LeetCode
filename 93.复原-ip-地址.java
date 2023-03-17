import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */

// @lc code=start
class Solution {
    /*
     * 不难，但是太啰嗦了，比如index的越界判断，合法性判断，小数点，递归层次，乱七八糟的
     */

    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        rec(s, 0, 0, 0, new StringBuilder());
        return ans;
    }

    private void rec(String s, int start, int end, int depth, StringBuilder sb) {
        if (end > s.length()) {
            return;
        }
        if (depth != 0) {
            sb.append(s.substring(start, end));
            sb.append('.');
        }
        if (depth == 4) {
            if (end == s.length()) {
                sb.deleteCharAt(sb.length() - 1);
                ans.add(sb.toString());
            }
            return;
        }

        depth++;
        if (valid(s, end, end + 1)) {
            rec(s, end, end + 1, depth, new StringBuilder(sb));
        }
        if (valid(s, end, end + 2)) {
            rec(s, end, end + 2, depth, new StringBuilder(sb));
        }
        if (valid(s, end, end + 3)) {
            rec(s, end, end + 3, depth, new StringBuilder(sb));
        }
    }

    private boolean valid(String s, int start, int end) {
        if (end > s.length())
            return false;
        if (end - start > 1 && s.charAt(start) == '0')
            return false;
        int v = Integer.parseInt(s.substring(start, end));
        if (v >= 0 && v <= 255) {
            return true;
        }
        return false;
    }
}
// @lc code=end
