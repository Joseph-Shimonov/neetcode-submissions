# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        q1 = deque([p])
        q2 = deque([q])

        while q1 and q2:
            for _ in range(len(q1)):
                p_node = q1.popleft()
                q_node = q2.popleft()

                if not p_node and not q_node:
                    continue
                
                if not p_node or not q_node or p_node.val != q_node.val:
                    return False
                
                q1.append(p_node.left)
                q1.append(p_node.right)
                q2.append(q_node.left)
                q2.append(q_node.right)
        
        return True