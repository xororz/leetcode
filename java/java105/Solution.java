package java105;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return bt(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    private TreeNode bt(int[] preorder, int[] inorder, int s1, int e1, int s2, int e2) {
        if (s1 == e1)
            return null;
        TreeNode node = new TreeNode(preorder[s1]);
        int i;
        for (i = s2; i < e2; i++) {
            if (inorder[i] == node.val) {
                break;
            }
        }
        int len = i - s2;
        node.left = bt(preorder, inorder, s1 + 1, s1 + 1 + len, s2, s2 + len);
        node.right = bt(preorder, inorder, s1 + 1 + len, e1, s2 + len + 1, e2);
        return node;
    }
}