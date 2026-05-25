# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        curr = dummy

        while n > 0:
            curr = curr.next
            n -= 1
        
        temp = dummy
        while curr and curr.next:
            curr = curr.next
            temp = temp.next
        
        temp.next = temp.next.next
    
        return dummy.next
