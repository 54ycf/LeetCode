import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] 基本计算器 II
 */

// @lc code=start
class Solution {

    /*
     * 我用的状态转移 比较绕
     * 
     * 可以用官方的先算乘除替换位置 最后算加减
     * 
     * 万能方法是转换成逆波兰式，还未了解
     */
    Stack<Integer> nums = new Stack<>();
    Stack<Character> ops = new Stack<>();
    int state = 0;

    public int calculate(String s) {
        int len = s.length();
        
        int num = 0;
        for(int i=0; i<len; ++i){
            char ch = s.charAt(i);
            if(ch==' '){
                continue;
            }else if(ch >= '0' && ch <= '9'){
                num = num*10+ch-'0';
            }else{
                stateTrans(num, ch);
                num = 0;
            }
        }
        stateTrans(num, '+');
        return nums.pop();
    }

    void stateTrans(int num, char ch){

        switch(state){
            case 0:
                nums.push(num);
                ops.push(ch); 
                switch(ch){
                    case '+': case '-':
                        state = 1;
                        break;
                    case '*': case '/':
                        state = 2;
                        break;
                }
                break;
            case 1:
                switch(ch){
                    case '+': case '-':
                        state = 1;
                        int topNum = nums.pop();
                        char topOp = ops.pop();
                        if(topOp=='+'){
                            topNum += num;
                            nums.push(topNum);
                        }else{
                            topNum -= num;
                            nums.push(topNum);
                        }
                        ops.push(ch);
                        break;
                    case '*': case '/':
                        state = 2;
                        nums.push(num);
                        ops.push(ch); 
                        break;
                }
                break;
            case 2:
                int topNum = nums.pop();
                char topOp = ops.pop();
                if(topOp=='*'){
                    topNum *= num;
                    nums.push(topNum);
                }else{
                    topNum /= num;
                    nums.push(topNum);
                }
                switch(ch){
                    case '*': case '/':
                        state = 2;
                        break;
                    case '+': case '-':
                        state = 1;
                        if(ops.isEmpty())
                            break;
                        topOp = ops.peek();
                        if(topOp=='+'){
                            int topNum1 = nums.pop();
                            int topNum2 = nums.pop();
                            ops.pop();
                            nums.push(topNum1+topNum2);
                        }else if(topOp=='-'){
                            int topNum1 = nums.pop();
                            int topNum2 = nums.pop();
                            ops.pop();
                            nums.push(topNum2-topNum1);
                        }
                        break;
                }
                ops.push(ch);
        }
    }
}
// @lc code=end

