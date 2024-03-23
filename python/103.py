from typing import List, Optional
from collections import deque


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        l = deque([root])
        path = deque()
        res = []
        left = True
        while len(l) > 0:
            for i in range(len(l)):
                node = l.popleft()
                if left:
                    path.append(node.val)
                else:
                    path.appendleft(node.val)
                if node.left:
                    l.append(node.left)
                if node.right:
                    l.append(node.right)
            res.append(list(path))
            path = deque()
            left = not left
        return res
