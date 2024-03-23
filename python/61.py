from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or k == 0:
            return head
        n = 0
        go = head
        while go != None:
            n += 1
            if go.next == None:
                go.next = head
                break
            go = go.next
        k %= n
        go.next = head
        tail = head
        for i in range(n - k - 1):
            head = head.next
        ans = head.next
        head.next = None
        return ans
