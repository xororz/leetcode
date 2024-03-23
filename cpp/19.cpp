/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution
{
public:
    ListNode *removeNthFromEnd(ListNode *head, int n)
    {
        ListNode *ans = head;
        ListNode *pre = head;
        while (head->next != nullptr)
        {
            n--;
            if (n < 0)
                pre = pre->next;
            head = head->next;
        }
        if (n > 0)
            return ans->next;
        if (pre->next == nullptr)
            return nullptr;
        pre->next = pre->next->next;
        return ans;
    }
};