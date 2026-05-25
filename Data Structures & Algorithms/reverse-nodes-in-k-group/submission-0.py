# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head:
            return None
        
        count = 0
        curr = head

        while curr:
            curr = curr.next
            count += 1
        
        curr = head
        dummy = ListNode()
        prev = dummy
        stack = []

        while count >= k:
            batch = k
            while batch:
                stack.append(curr)
                curr = curr.next
                batch -= 1
            while stack:
                prev.next = stack.pop()
                prev = prev.next
            count -= k
        prev.next = curr if curr else None
        return dummy.next