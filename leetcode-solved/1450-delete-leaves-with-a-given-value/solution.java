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
  public TreeNode removeLeafNodes(TreeNode root, int target) {
        recursive(null, root, target, false);
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }

    public void recursive(TreeNode pre, TreeNode current, int target, boolean isLeft) {
        if (current.left != null) {
            recursive(current, current.left, target, true);
        }
        if (current.right != null) {
            recursive(current, current.right, target, false);
        }
        if (current.left == null && current.right == null && current.val == target) {
            if (pre == null)
                return;
            if (isLeft)
                pre.left = null;
            else
                pre.right = null;
        }
    }
}
