import java.util.Stack;

/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
class Solution {
    public String decodeString(String s) {
        Stack<String>  strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int len = s.length();

        int num = 0;
        for(int i=0; i<len; ++i){
            char ch = s.charAt(i);
            if(ch==']'){
                String topStr = strStack.pop();
                String tmp = "";
                while(!topStr.equals("[")){
                    tmp = topStr + tmp;
                    topStr = strStack.pop();
                }
                int rep = numStack.pop();
                String str = "";
                while(rep!=0){
                    rep--;
                    str = str + tmp;
                }
                strStack.push(str);
                num = 0;
            }else if(ch == '['){
                numStack.push(num);
                strStack.push("[");
                num=0;
            }else if(Character.isDigit(ch)){
                num = num * 10 + ch - '0';
            }else if(Character.isLetter(ch)){
                strStack.push(String.valueOf(ch));
            }
        }
        String res = "";
        while(!strStack.isEmpty()){
            res = strStack.pop() + res;
        }
        return res;
    }
}
// @lc code=end

