/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    /*
     * 前序：[ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
     * 中序：[ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return rec(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode rec(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl > pr)
            return null;
        int rootVal = preorder[pl];
        TreeNode root = new TreeNode(rootVal);
        if (pl == pr)
            return root;
        int i;
        for (i = il; i <= ir; ++i) {
            if (inorder[i] == rootVal)
                break;
        }
        int len = i - il;
        root.left = rec(preorder, inorder, pl + 1, pl + len, il, i - 1);
        root.right = rec(preorder, inorder, pl + len + 1, pr, i + 1, ir);
        return root;
    }
}
// @lc code=end
