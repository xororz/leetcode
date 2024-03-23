package java143;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public void reorderList(ListNode head) {
        if (head == null)
            return;
        ListNode go = head;
        go = go.next;
        Deque<ListNode> s = new ArrayDeque<>();
        while (go != null) {
            s.add(go);
            go = go.next;
        }
        go = head;
        while (true) {
            if (s.isEmpty())
                break;
            ListNode tmp = s.pollLast();
            go.next = tmp;
            tmp.next = null;
            go = go.next;
            if (s.isEmpty())
                break;
            tmp = s.pollFirst();
            go.next = tmp;
            tmp.next = null;
            go = go.next;
        }
    }
}