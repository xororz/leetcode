package java117;

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Node left = root;
        Node tobeconnected = null;
        Node connect = null;
        while (left != null) {
            Node go = left;
            left = null;
            while (go != null) {
                if (left == null) {
                    if (go.left != null)
                        left = go.left;
                    else if (go.right != null) {
                        left = go.right;
                    }
                }
                if (go.left != null) {
                    connect = go.left;
                    if (tobeconnected != null)
                        tobeconnected.next = connect;
                    if (go.right != null) {
                        go.left.next = go.right;
                        tobeconnected = go.right;
                    } else
                        tobeconnected = go.left;
                } else {
                    if (go.right != null) {
                        connect = go.right;
                        if (tobeconnected != null)
                            tobeconnected.next = connect;
                        tobeconnected = go.right;
                    }
                }
                go = go.next;
            }
            tobeconnected = null;
        }
        return root;
    }
}