/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    
    //边界很绕！以及))的情况分析得仔细
    public int longestValidParentheses(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int maxLen = 0;
        for (int i = 1; i < len; i++) {
            char ch = s.charAt(i);
            if(ch == ')'){
                if(s.charAt(i-1) == '('){
                    if(i>=2) dp[i] = dp[i-2]+2; //____()有两个，然后加上前面的紧挨着的最大长度
                    else     dp[i] = 2; //()，最前面了，再往前没有了，会越界错误，所以单独判断
                }else{
                    int ind = i-dp[i-1]-1;
                    if(ind >= 0 && s.charAt(ind) == '('){//_____))，如果前面这个)的地方结尾是有结果的，长度为l，就往左走l个，找到前面有没有对应的(,
                        dp[i] = dp[i-1]+2; 
                        if(ind>0)
                            dp[i] += dp[ind-1]; //如果没有越界，就要加上i-1对应的最长+2，以及往左走了l个多再左边的最长，如果能连接上就都要加上
                    }
                
                }

            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
// @lc code=end
