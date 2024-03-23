package java116;

class Solution {
    public Node connect(Node root) {
        preorder(root);
        return root;
    }

    public NN preorder(Node root) {
        if (root == null)
            return null;
        if (root.left == null)
            return new NN(root, root);
        root.left.next = root.right;
        NN l = preorder(root.left);
        NN r = preorder(root.right);
        if (l != null) {
            l.r.next = r.l;
        }
        return new NN(l.l, r.r);
    }
}