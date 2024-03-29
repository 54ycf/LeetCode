/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    /*
     * 假想「乌龟」和「兔子」在链表上移动，「兔子」跑得快，「乌龟」跑得慢。当「乌龟」和「兔子」从链表上的同一个节点开始移动时，如果该链表中没有环，那么「兔子」
     * 将一直处于「乌龟」的前方；如果该链表中有环，那么「兔子」会先于「乌龟」进入环，并且一直在环内移动。等到「乌龟」进入环时，由于「兔子」的速度快，
     * 它一定会在某个时刻与乌龟相遇，即套了「乌龟」若干圈
     */
    public boolean hasCycle(ListNode head) {
        ListNode rabbit = head;
        ListNode dummy = new ListNode();
        dummy.next = rabbit;
        ListNode tortoise = dummy;
        while (true) {
            if (rabbit == null || rabbit.next == null)
                return false;
            if (tortoise == rabbit)
                return true;
            tortoise = tortoise.next;
            rabbit = rabbit.next.next;
        }

    }
}
// @lc code=end
