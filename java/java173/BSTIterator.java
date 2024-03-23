package java173;

import java.util.Stack;

class BSTIterator {

    Stack<TreeNode> s = new Stack<>();

    public BSTIterator(TreeNode root) {
        s.add(root);
    }

    public int next() {
        while (s.peek().left != null) {
            TreeNode left = s.peek().left;
            s.peek().left = null;
            s.add(left);
        }
        int res;
        if (s.peek().right != null) {
            TreeNode right = s.peek().right;
            res = s.pop().val;
            s.add(right);
        } else {
            res = s.pop().val;
        }
        return res;
    }

    public boolean hasNext() {
        return !s.empty();
    }
}
