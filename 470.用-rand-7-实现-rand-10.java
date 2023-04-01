/*
 * @lc app=leetcode.cn id=470 lang=java
 *
 * [470] 用 Rand7() 实现 Rand10()
 */

// @lc code=start
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    /*
     * 数字的选择与舍弃，最后概率的组合
     */
    public int rand10() {
        int first, second;
        while((first=rand7())<6);
        while((second=rand7())>5);
        if(first==6)return second;
        else return second+5;
    }
}
// @lc code=end

