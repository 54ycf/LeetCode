import java.util.Stack;

/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉 K 位数字
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {//this kind of question is still hard for me
        int n = num.length();
        int hasHandledNum = 0;
        
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<n; ++i){
            Character ch = num.charAt(i);
            while(!stack.isEmpty() && ch.compareTo(stack.peek()) < 0 && hasHandledNum<k){
                stack.pop();
                ++hasHandledNum;
            }
            stack.push(ch);
        }
        StringBuffer str = new StringBuffer();
        for(Character ch : stack){
            str.append(ch);
        }
        if(hasHandledNum < k){
            str.delete(str.length()-(k-hasHandledNum), str.length()); //i'm confused by it
        }

        System.out.println(str);
        while(!str.toString().equals("") && str.charAt(0) == '0') str.deleteCharAt(0);
        String result = str.toString();
        if(result.equals("")) return "0";
        return result;

    }
}
// @lc code=end

