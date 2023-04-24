import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 反转字符串中的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        List<String> splits = Arrays.asList(s.split("\\s+"));
        Collections.reverse(splits);
        return String.join(" ", splits);
    }
}
// @lc code=end

