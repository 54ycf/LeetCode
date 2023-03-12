/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
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
     * 关键是数学上的推导，并且要知道a=c+(n−1)(b+c) 这个数据怎么用
     * 在第一次相遇之后，fast要回到head，并且一次走一个，最后能走到交汇处，你细品
     * 
     * 这种和160的思想类似，都是数学推导，回到头部
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                break;
        }
        fast = head;
        while (true) {
            if (fast == slow)
                return fast;
            fast = fast.next;
            slow = slow.next;
        }

    }
}
// @lc code=end
