import java.util.Stack;

/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {
    //输入栈和输出栈，别每次都傻乎乎倒腾一下
    Stack<Integer> inpuStack;
    Stack<Integer> outpuStack;

    public MyQueue() {
        inpuStack = new Stack<>();
        outpuStack = new Stack<>();
    }

    public void push(int x) {
        inpuStack.push(x);
    }

    public int pop() {
        if (outpuStack.isEmpty()) {
            while (!inpuStack.isEmpty()) {
                outpuStack.push(inpuStack.pop());
            }
        }
        return outpuStack.pop();
    }

    public int peek() {
        if (outpuStack.isEmpty()) {
            while (!inpuStack.isEmpty()) {
                outpuStack.push(inpuStack.pop());
            }
        }
        return outpuStack.peek();
    }

    public boolean empty() {
        return inpuStack.isEmpty() && outpuStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end
