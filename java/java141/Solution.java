package java141;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode rabbit = head, turtle = head;
        while (true) {
            if (rabbit == null)
                return false;
            rabbit = rabbit.next;
            if (rabbit == turtle)
                return true;
            if (rabbit == null)
                return false;
            rabbit = rabbit.next;
            if (rabbit == turtle)
                return true;
            turtle = turtle.next;
        }
    }
}