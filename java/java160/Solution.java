package java160;

import java.util.Stack;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> a = new Stack<>();
        Stack<ListNode> b = new Stack<>();
        while (headA != null) {
            a.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            b.push(headB);
            headB = headB.next;
        }
        ListNode res = null;
        while (true) {
            if (a.empty() || b.empty())
                break;
            ListNode s = a.pop();
            ListNode t = b.pop();
            if (s == t)
                res = s;
        }
        return res;
    }
}