package java145;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> l;

    public List<Integer> postorderTraversal(TreeNode root) {
        l = new ArrayList<>();
        postorderTraversal2(root);
        return l;
    }

    public void postorderTraversal2(TreeNode root) {
        if (root == null)
            return;
        postorderTraversal2(root.left);
        postorderTraversal2(root.right);
        l.add(root.val);
    }
}