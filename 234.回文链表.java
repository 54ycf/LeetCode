/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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
 * 找到中点，翻转一半，依次比较，空间O1
 * 有一种递归写法，空间On，很6
 */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        // 找到中心点，然后一边找一边反转前半部分
        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        // 如果有偶数个节点，例如1 2 3 1，此时slow在3，prev在2
        // 如果有奇数个节点，例如1 2 3 4 5，此时slow在3，prev在2，要让slow在4才合理
        if (fast != null)
            slow = slow.next; // 奇数个，要向前迈进1个
        while (prev != null && slow != null) {
            if (prev.val != slow.val)
                return false;
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }
}
// @lc code=end
