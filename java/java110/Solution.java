package java110;

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return height(root) != -1;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hl = height(root.left);
        int hr = height(root.right);
        // System.out.printf("%d %d %d\n", root.val, hl, hr);
        if (hl == -1 || hr == -1)
            return -1;
        if (Math.abs(hl - hr) <= 1)
            return Math.max(hl, hr) + 1;
        return -1;
    }
}