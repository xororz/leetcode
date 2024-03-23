package java106;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> m = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            m.put(inorder[i], i);
        }
        return bt(inorder, postorder, 0, inorder.length, 0, postorder.length);
    }

    private TreeNode bt(int[] inorder, int[] postorder, int s1, int e1, int s2, int e2) {
        if (s1 == e1)
            return null;
        TreeNode node = new TreeNode(postorder[e2 - 1]);
        int len = m.get(postorder[e2 - 1]) - s1;
        node.left = bt(inorder, postorder, s1, s1 + len, s2, s2 + len);
        node.right = bt(inorder, postorder, s1 + len + 1, e1, s2 + len, e2 - 1);
        return node;
    }
}