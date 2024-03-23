#include <iostream>
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
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
    {
        ListNode *ret = l2;
        int c = 0;
        while (1)
        {
            if (!l1)
            {
                if (!l2)
                    break;
                l2->val += c;
                if (l2->val > 9)
                {
                    c = 1;
                    l2->val -= 10;
                }
                else
                    c = 0;
                if (c == 1 && l2->next == nullptr)
                {
                    l2->next = new ListNode(1);
                    l2 = l2->next;
                    break;
                }
                l2 = l2->next;
                continue;
            }
            if (!l2->next)
                if (l1->next)
                {
                    ListNode *tmp = l2->next;
                    l2->next = l1->next;
                    l1->next = tmp;
                }
            int l = l1->val + c;
            l2->val += l;
            if (l2->val > 9)
            {
                c = 1;
                l2->val -= 10;
            }
            else
                c = 0;
            if (c == 1 && l2->next == nullptr)
            {
                l2->next = new ListNode(1);
                l2 = l2->next;
                break;
            }
            l1 = l1->next;
            l2 = l2->next;
        }
        return ret;
    }
};

int main()
{
    ListNode *l1 = new ListNode(9);
    l1->next = new ListNode(9);
    l1->next->next = new ListNode(9);
    l1->next->next->next = new ListNode(9);
    l1->next->next->next->next = new ListNode(9);
    l1->next->next->next->next->next = new ListNode(9);
    l1->next->next->next->next->next->next = new ListNode(9);
    ListNode *l2 = new ListNode(9);
    l2->next = new ListNode(9);
    l2->next->next = new ListNode(9);
    l2->next->next->next = new ListNode(9);
    Solution s;
    ListNode *res = s.addTwoNumbers(l1, l2);
    while (res)
    {
        cout << res->val << " ";
        res = res->next;
    }
}