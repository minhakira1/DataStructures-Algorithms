# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return false
        return self.isMirror(root.left, root.right)
    def isMirror(self, nodeLeft: TreeNode, nodeRight: TreeNode) -> bool:
        if not nodeLeft and not nodeRight:
            return True
        if not nodeLeft or not nodeRight:
            return False
        return nodeLeft.val == nodeRight.val and self.isMirror(nodeLeft.left, nodeRight.right) and self.isMirror(nodeLeft.right, nodeRight.left) 
