/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
     * 还有一种前后双指针的做法也很简单
     */
    int n;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        this.n = n;
        ListNode dummy = new ListNode();
        dummy.next = head;
        rec(dummy);
        return dummy.next;
    }

    private int rec(ListNode head) {
        if (head == null) {
            return 0;
        }
        int depth = rec(head.next) + 1;
        if (depth == n + 1) {
            head.next = head.next.next;
        }
        return depth;

    }
}
// @lc code=end
