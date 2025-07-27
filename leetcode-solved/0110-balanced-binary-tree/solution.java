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
    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    public int maxDepth(TreeNode root) {
        // 1. Trường hợp cơ bản (điểm dừng)
        if (root == null)
            return 0;

        // 2. Đệ quy xuống hai cây con
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        //3. KIỂM TRA CÂN BẰNG (Đây là bước quan trọng nhất!)
        if (Math.abs(l - r) > 1) {
            result = false;
        }
        return 1 + Math.max(l, r);
    }
}
