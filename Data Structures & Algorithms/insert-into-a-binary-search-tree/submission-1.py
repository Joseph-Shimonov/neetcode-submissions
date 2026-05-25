# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def insertIntoBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        curr = root
        while curr:
            if not curr.left and val < curr.val:
                curr.left = TreeNode(val)
                return root
            if not curr.right and val > curr.val:
                curr.right = TreeNode(val)
                return root

            if val < curr.val:
                curr = curr.left
            else:
                curr = curr.right
        return TreeNode(val)