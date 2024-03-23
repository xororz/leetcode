from typing import List, Optional
from collections import deque


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        l = deque([root])
        ll = deque()
        path = []
        res = []
        while len(l) + len(ll) > 0:
            if len(l) == 0:
                l, ll = ll, l
                res.append(path)
                path = []
            node = l[0]
            if node:
                path.append(node.val)
                ll.append(node.left)
                ll.append(node.right)
            l.popleft()
        return res
