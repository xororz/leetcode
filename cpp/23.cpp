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
    ListNode *mergeKLists(vector<ListNode *> &lists)
    {
        int n = lists.size();
        ListNode *ans = new ListNode();
        ListNode *go = ans;
        int selected;
        while (true)
        {
            int notnull = 0;
            int maxval = __INT_MAX__;
            for (int i = 0; i < n; i++)
            {
                if (lists[i] != nullptr)
                {
                    notnull++;
                    if (lists[i]->val < maxval)
                    {
                        selected = i;
                        maxval = lists[i]->val;
                    }
                }
            }
            if (notnull == 0)
                break;
            go->next = lists[selected];
            lists[selected] = lists[selected]->next;
            go = go->next;
        }
        return ans->next;
    }
};