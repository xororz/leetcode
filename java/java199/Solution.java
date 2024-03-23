package java199;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<Integer> res;

    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int height) {
        if (root == null)
            return;
        if (height >= res.size()) {
            res.add(root.val);
        } else {
            res.set(height, root.val);
        }
        dfs(root.left, height + 1);
        dfs(root.right, height + 1);
    }
}