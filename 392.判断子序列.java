/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.equals("")) return true;
        String[] sArr = s.split("");
        String[] tArr = t.split("");
        int tPoint = 0;
        try{
            for (String sItem : sArr) {
                while(!sItem.equals(tArr[tPoint])){
                    ++tPoint;
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }

        return true;
    }
}
// @lc code=end

