package java144;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> l;

    public List<Integer> preorderTraversal(TreeNode root) {
        l = new ArrayList<>();
        preorderTraversal2(root);
        return l;
    }

    public void preorderTraversal2(TreeNode root) {
        if (root == null)
            return;
        l.add(root.val);
        preorderTraversal2(root.left);
        preorderTraversal2(root.right);
    }
}