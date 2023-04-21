/*
 * @lc app=leetcode.cn id=622 lang=java
 *
 * [622] 设计循环队列
 */

// @lc code=start
class MyCircularQueue {
    int[] q;
    int front;
    int rear;
    int maxSize;

    /*
     * 经典基础，常来看看
     */

    public MyCircularQueue(int k) {
        this.maxSize = k+1;
        this.q = new int[maxSize];
        this.front = 0;
        this.rear = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        q[rear] = value;
        rear = (rear+1)%maxSize;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        front = (front+1)%maxSize;
        return true;
    }
    
    public int Front() {
        if(isEmpty())return -1;
        return q[front];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        int lastInd = (rear-1+maxSize)%maxSize;
        return q[lastInd];
    }
    
    public boolean isEmpty() {
        return front==rear;
    }
    
    public boolean isFull() {
        return (rear+1)%maxSize==front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
// @lc code=end

