/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode lastHead;
        ListNode curHead; // 每次小遍历的头
        ListNode curTail;
        ListNode dummy = new ListNode();
        ListNode node = head;
        dummy.next = head;
        curHead = head;
        lastHead = dummy;

        boolean flag = true;
        while (flag && node != null) {
            int i = 1;
            while (node.next != null && i < k) {
                node = node.next;
                ++i;
            }
            if (i == k) {
                curTail = node;
                ListNode next = node.next;
                reversePart(curHead, curTail);
                lastHead.next = curTail;
                lastHead = curHead;
                curHead = next;
            } else {
                lastHead.next = curHead;
                flag = false;
            }
            node = curHead;
        }
        return dummy.next;
    }

    private ListNode reversePart(ListNode head, ListNode tail) {
        ListNode cur, pre, next;
        cur = head;
        pre = null;
        while (pre != tail) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
// @lc code=end
