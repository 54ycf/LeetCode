import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null)
            stack.push(root);
        boolean even = true;
        while (!stack.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            Stack<TreeNode> youngStack = new Stack<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                levelList.add(node.val);
                TreeNode node1 = even ? node.left : node.right;
                TreeNode node2 = even ? node.right : node.left;
                if (node1 != null) {
                    youngStack.push(node1);
                }
                if (node2 != null) {
                    youngStack.push(node2);
                }
            }
            even = !even;
            stack = youngStack;
            res.add(levelList);
        }
        return res;
    }
}
// @lc code=end
