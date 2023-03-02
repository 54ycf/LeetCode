import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0; //子串开始的位置
        int max = 0;
        for (int i = 0; i < len; i++) {
            Character ch = s.charAt(i);
            if(map.containsKey(ch)){
                int ind = map.get(ch); //第一个重复的位置
                for (int j = left; j <= ind; j++) {
                    map.remove(s.charAt(j));
                }
                map.put(ch, i);
                int tmp = i-left;
                max = max > tmp? max:tmp;
                left = ind+1;
            }else{
                map.put(ch, i);
            }
        }
        int tmp = len - left;
        max = max > tmp? max:tmp;
        return max;
    }
}
// @lc code=end

