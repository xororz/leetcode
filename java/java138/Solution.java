package java138;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node newHead = new Node(head.val);
        Map<Node, Node> m = new HashMap<>();
        m.put(head, newHead);
        Node go1 = head;
        Node go2 = newHead;
        while (go1 != null) {
            if (go1.next != null) {
                Node tmp;
                if (m.containsKey(go1.next)) {
                    tmp = m.get(go1.next);
                } else {
                    tmp = new Node(go1.next.val);
                    m.put(go1.next, tmp);
                }
                go2.next = tmp;
            }
            if (go1.random != null) {
                Node tmp;
                if (m.containsKey(go1.random)) {
                    tmp = m.get(go1.random);
                } else {
                    tmp = new Node(go1.random.val);
                    m.put(go1.random, tmp);
                }
                go2.random = tmp;
            }
            go1 = go1.next;
            go2 = go2.next;
        }
        return newHead;
    }
}