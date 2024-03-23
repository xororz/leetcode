# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


from typing import Optional


class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.prev = TreeNode(float("-inf"))
        self.first = None
        self.second = None
        self.dfs(root)
        self.first.val, self.second.val = self.second.val, self.first.val

    def dfs(self, root):
        if not root:
            return
        self.dfs(root.left)
        if not self.first and self.prev.val >= root.val:
            self.first = self.prev
        if self.first and self.prev.val >= root.val:
            self.second = root
        self.prev = root
        self.dfs(root.right)
