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
    ListNode *reverseKGroup(ListNode *head, int k)
    {
        ListNode *go = head;
        int i = 0;
        while (i++ < k)
        {
            if (go == NULL)
            {
                return head;
            }
            go = go->next;
        }
        ListNode *tmp = head->next;
        head->next = reverseKGroup(go, k);
        i = 0;
        while (i++ < k - 1)
        {
            ListNode *next = tmp->next;
            tmp->next = head;
            head = tmp;
            tmp = next;
        }
        return head;
    }
};