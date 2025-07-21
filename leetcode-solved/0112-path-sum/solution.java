/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        return sumValues(root, targetSum);
    }

    public boolean sumValues(TreeNode node, int remainValue) {
        if (node == null)
            return false;
        if (node.left == null && node.right == null) {
            return remainValue == node.val;
        }
        boolean checkLeft = sumValues(node.left, remainValue - node.val);
        boolean checkRight = sumValues(node.right, remainValue - node.val);
        return checkLeft || checkRight;
    }
}
