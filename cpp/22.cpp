#include <bits/stdc++.h>

using namespace std;
class Solution
{
public:
    vector<string> generateParenthesis(int n)
    {
        vector<string> ans;
        int state = 0;
        string tmp = "";
        dfs(ans, state, tmp, n, n);
        return ans;
    }
    void dfs(vector<string> &ans, int state, string tmp, int left, int right)
    {
        if (state < 0)
            return;
        if (left == 0 && right == 0)
        {
            ans.push_back(tmp);
        }
        if (left > 0)
        {
            dfs(ans, state + 1, tmp + "(", left - 1, right);
        }
        if (right > 0)
        {
            dfs(ans, state - 1, tmp + ")", left, right - 1);
        }
    }
};