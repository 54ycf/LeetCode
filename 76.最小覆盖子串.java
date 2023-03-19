import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    int[] target = new int[150];
    int[] smap = new int[150];
    /*
     * 滑动窗口，不满足右移右指针添加集合，满足就尽量右移左指针
     * 注意点while循环的结束情况的遗漏
     */

    public String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); ++i) {
            target[t.charAt(i)]++;
        }
        int left = 0, right = 0;
        int l = -1, r = 0, resLen = Integer.MAX_VALUE;
        while (right <= s.length()) {
            if (check()) {
                if ((right - left) < resLen) {
                    resLen = right - left;
                    l = left;
                    r = right;
                }
                smap[s.charAt(left)]--;
                ++left;
            } else {
                if (right == s.length()) //这里写的真丑
                    break;
                smap[s.charAt(right)]++; // 尾部没有处理
                ++right;
            }
        }
        if (l != -1)
            return s.substring(l, r);
        return "";
    }

    public boolean check() {
        for (int i = 0; i < 150; ++i) {
            if (smap[i] < target[i])
                return false;
        }
        return true;
    }
}
// @lc code=end
