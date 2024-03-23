package java109;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> l = new ArrayList<>();
        while (head != null) {
            l.add(head.val);
            head = head.next;
        }
        return sortedListToBST(l, 0, l.size() - 1);
    }

    public TreeNode sortedListToBST(List<Integer> l, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(l.get(mid));
        root.left = sortedListToBST(l, start, mid - 1);
        root.right = sortedListToBST(l, mid + 1, end);
        return root;
    }
}