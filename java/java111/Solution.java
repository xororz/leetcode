package java111;

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int hl = 9999999, hr = 9999999;
        if (root.left != null)
            hl = minDepth(root.left);
        if (root.right != null)
            hr = minDepth(root.right);
        return Math.min(hl, hr) + 1;
    }
}