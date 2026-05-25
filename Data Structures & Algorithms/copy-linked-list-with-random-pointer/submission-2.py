"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        d = {}
        curr = head

        while curr:
            copy = Node(curr.val)
            d[curr] = copy
            curr = curr.next
        
        curr = head
        while curr:
            copy = d[curr]
            copy.next = d.get(curr.next)
            copy.random = d.get(curr.random)
            curr = curr.next
        return d.get(head)