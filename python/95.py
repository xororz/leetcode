from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def generateTrees(self, n: int) -> List[Optional[TreeNode]]:
        return self.generate(1, n)

    def generate(self, start, end):
        if start == end:
            return [TreeNode(start)]
        if start > end:
            return [None]
        result = []
        for i in range(start, end + 1):
            left = self.generate(start, i - 1)
            right = self.generate(i + 1, end)
            for l in left:
                for r in right:
                    root = TreeNode(i)
                    root.left = l
                    root.right = r
                    result.append(self.copytree(root))
        return result

    def copytree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return None
        newroot = TreeNode(root.val)
        newroot.left = self.copytree(root.left)
        newroot.right = self.copytree(root.right)
        return newroot


Solution().generateTrees(3)
