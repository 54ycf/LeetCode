import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node,Node> map = new HashMap<>(); //老节点-》新节点

    public Node copyRandomList(Node head) {
        if(head==null) return null;
        if(!map.containsKey(head)){
            Node newHead = new Node(head.val);
            map.put(head, newHead);
            newHead.random = copyRandomList(head.random);
            newHead.next = copyRandomList(head.next);
            return newHead;
        }else{
            return map.get(head);
        }
    }

    //还有一种节点拆分法 
    /*
     * A→A′→B→B′→C→C′
     * public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
    } 
     */

}
// @lc code=end

