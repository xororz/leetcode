package java133;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        boolean[] v = new boolean[101];
        Map<Integer, Node> m = new HashMap<>();
        Node newNode = new Node(node.val);
        m.put(1, newNode);
        dfs(node, newNode, v, m);
        return newNode;
    }

    public void dfs(Node node, Node copyNode, boolean[] v, Map<Integer, Node> m) {
        if (v[node.val])
            return;
        v[node.val] = true;
        for (Node n : node.neighbors) {
            if (!m.containsKey(n.val))
                m.put(n.val, new Node(n.val));
            copyNode.neighbors.add(m.get(n.val));
        }
        for (int i = 0; i < node.neighbors.size(); i++) {
            Node n = node.neighbors.get(i);
            Node ncopy = copyNode.neighbors.get(i);
            dfs(n, ncopy, v, m);
        }
    }
}