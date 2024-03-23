#include <bits/stdc++.h>

using namespace std;
struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
class Solution
{
public:
    ListNode *swapPairs(ListNode *head)
    {
        head = new ListNode(0, head);
        ListNode *ans = head;
        while (head->next != nullptr)
        {
            if (head->next->next == nullptr)
                break;
            ListNode *tmp = head->next;
            head->next = head->next->next;
            tmp->next = head->next->next;
            head->next->next = tmp;
            head = head->next->next;
        }
        return ans->next;
    }
};

ListNode *makeList(vector<int> &v)
{
    ListNode *ans = new ListNode();
    ListNode *go = ans;
    for (int i = 0; i < v.size(); i++)
    {
        go->next = new ListNode(v[i]);
        go = go->next;
    }
    return ans->next;
}

int main()
{
    vector<int> v = {1, 2, 3, 4};
    ListNode *head = makeList(v);
    Solution solution;
    ListNode *ans = solution.swapPairs(head);
    while (ans != nullptr)
    {
        cout << ans->val << " ";
        ans = ans->next;
    }
    return 0;
}
