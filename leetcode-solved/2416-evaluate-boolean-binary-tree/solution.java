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
  public boolean evaluateTree(TreeNode root) {
    return recursive(root);
  }

  public boolean recursive(TreeNode current) {
    if (current.val == 1)
      return true;
    else if (current.val == 0)
      return false;
    else if (current.val == 2) {
      if (current.left != null && current.right != null)
        return recursive(current.left) || recursive(current.right);
      else if (current.left != null)
        return recursive(current.left);
      else if (current.right != null)
        return recursive(current.right);
    }
    return recursive(current.left) && recursive(current.right);
  }
}
