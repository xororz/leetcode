package java148;

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null)
            return head;
        int l = 0;
        ListNode go = head;
        while (go != null) {
            l++;
            go = go.next;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode d = dummy;
        ListNode e;
        int step, i, j;
        for (step = 2; step < 2 * l; step *= 2) {
            d = dummy;
            e = d;
            for (i = 0; i < l; i += step) {
                ListNode dd = new ListNode(0);
                ListNode ddd = dd;
                ListNode l1, l2;
                if (l - i <= step / 2)
                    continue;
                l1 = d.next;
                for (j = 0; j < step / 2; j++) {
                    e = e.next;
                }
                l2 = e.next;
                for (j = i + step / 2; j < Math.min(l, i + step); j++) {
                    e = e.next;
                }
                ListNode end = e.next;
                int n1 = 0, n2 = 0;
                while (n1 < step / 2 && n2 < Math.min(l, i + step) - i - step / 2) {
                    if (l1.val <= l2.val) {
                        dd.next = l1;
                        l1 = l1.next;
                        n1++;
                    } else {
                        dd.next = l2;
                        l2 = l2.next;
                        n2++;
                    }
                    dd = dd.next;
                }
                if (n1 < step / 2) {
                    dd.next = l1;
                } else {
                    dd.next = l2;
                }
                d.next = ddd.next;
                dd = d;
                for (int k = 0; k < Math.min(step, l - i); k++) {
                    dd = dd.next;
                }
                dd.next = end;
                d = dd;
                e = d;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1))));
        Solution s = new Solution();
        ListNode res = s.sortList(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}