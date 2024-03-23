package java129;

class Solution {
    int res;

    public int sumNumbers(TreeNode root) {
        res = 0;
        preOrder(root, 0);
        return res;
    }

    public void preOrder(TreeNode root, int num) {
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += num;
            num /= 10;
            return;
        }
        if (root.left != null)
            preOrder(root.left, num);
        if (root.right != null)
            preOrder(root.right, num);
        num /= 10;
        return;
    }
}