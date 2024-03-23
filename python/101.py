from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.duichen(root.left, root.right)

    def duichen(self, t1, t2):
        if t1 and t2:
            return (
                t1.val == t2.val
                and self.duichen(t1.left, t2.right)
                and self.duichen(t1.right, t2.left)
            )
        else:
            return t1 is t2
