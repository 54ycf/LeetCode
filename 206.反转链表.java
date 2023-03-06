/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /*
     * 循环的关键是prev cur 和 next三个指针
     * 递归可以见网站“动画演示+多种解法 206. 反转链表”
     * 的动画演示，我的递归思路low了点，这个代码更加美观
     */

    private ListNode res;

    public ListNode reverseList(ListNode head) {
        /* 循环的方法 */
        // ListNode prev = null;
        // ListNode cur = head;
        // while (cur != null) {
        // ListNode next = cur.next;
        // cur.next = prev;
        // prev = cur;
        // cur = next;
        // }
        // return prev;

        rec(head);
        return res;
    }

    private ListNode rec(ListNode head) {
        /* 递归的方法 */
        if (head == null || head.next == null) {
            res = head;
            return head;
        }
        ListNode t = rec(head.next);
        t.next = head;
        head.next = null;
        return head;
    }
}
// @lc code=end
