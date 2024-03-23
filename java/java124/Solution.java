package java124;

class Solution {
    int res;

    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        int l = maxPathSum(root, true);
        int r = maxPathSum(root, false);
        res = Math.max(res, l + root.val);
        res = Math.max(res, r + root.val);
        res = Math.max(res, l + r + root.val);
        res = Math.max(res, root.val);
        return res;
    }

    public int maxPathSum(TreeNode root, Boolean left) {
        if (root == null)
            return 0;
        if (left) {
            if (root.left == null)
                return 0;
            int l = maxPathSum(root.left, true);
            int r = maxPathSum(root.left, false);
            res = Math.max(res, root.left.val + l);
            res = Math.max(res, root.left.val + r);
            res = Math.max(res, root.left.val + l + r);
            res = Math.max(res, root.left.val);
            return root.left.val + Math.max(Math.max(l, r), 0);
        } else {
            if (root.right == null)
                return 0;
            int l = maxPathSum(root.right, true);
            int r = maxPathSum(root.right, false);
            res = Math.max(res, root.right.val + l);
            res = Math.max(res, root.right.val + r);
            res = Math.max(res, root.right.val + l + r);
            res = Math.max(res, root.right.val);
            return root.right.val + Math.max(0, Math.max(l, r));
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new Solution().maxPathSum(root));
    }
}