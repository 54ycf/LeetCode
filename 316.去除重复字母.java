import java.util.Stack;

/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 */

// @lc code=start
class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] isOccupy = new boolean[30];
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        isOccupy[s.charAt(0)-'a']=true;
        for(int i=1;i<s.length();++i){
            Character cur = s.charAt(i);
            if(isOccupy[cur-'a']){
                continue;
            }
            // while(!stack.isEmpty() && stack.peek() > cur){
            //     if(s.indexOf(stack.peek(),i)==-1)
            //         break;
            //     isOccupy[stack.pop()-'a']=false;
            // }
            //上面的while想了好久，最后抄的解析，真的被绕蒙了
        
            
            stack.push(cur);
            isOccupy[cur-'a']=true;
        
        }
        char[] arr = new char[stack.size()];
        for(int i=arr.length-1;i>=0;--i){
            arr[i] = stack.pop();
        }
        return String.valueOf(arr);
    }
}
// @lc code=end

