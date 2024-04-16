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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        return addRow(root, val, depth, 1);
    }

    public TreeNode addRow(TreeNode root, int val, int depth, int current) {
        if (root == null)
            return null;
        if (current == depth -1) {
            TreeNode leftTemp = root.left;
            TreeNode rightTemp = root.right;
            // add a row value to depth
            root.left = new TreeNode(val);
            root.right = new TreeNode(val);
            root.left.left = leftTemp;
            root.right.right = rightTemp;

            return root;
        }

        root.left = addRow(root.left, val, depth, current + 1);
        root.right = addRow(root.right, val, depth, current + 1);
        
        return root;
    }
}
