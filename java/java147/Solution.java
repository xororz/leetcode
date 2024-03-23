package java147;

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0, head);
        ListNode go = head.next;
        ListNode pre = head;
        int steps = 1;
        while (go != null) {
            if (go.val >= pre.val) {
                go = go.next;
                pre = pre.next;
                steps++;
                continue;
            }
            ListNode next = go.next;
            pre.next = next;
            ListNode go2 = dummy;
            for (int i = 0; i < steps; i++) {
                if (go.val < go2.next.val) {
                    break;
                }
                go2 = go2.next;
            }
            go.next = go2.next;
            go2.next = go;
            go = next;
            steps++;
        }
        return dummy.next;
    }
}