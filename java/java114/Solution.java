package java114;

class Solution {
    public void flatten(TreeNode root) {
        flatten1(root);
    }

    public TreeNode flatten1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = flatten1(left);
        root.left = null;
        TreeNode go = root;
        while (go.right != null) {
            go = go.right;
        }
        go.right = flatten1(right);
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode test = new TreeNode(1);
        test.left = new TreeNode(2);
        test.right = new TreeNode(3);
        s.flatten(test);
    }
}