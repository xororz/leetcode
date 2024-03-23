#include <bits/stdc++.h>

using namespace std;

class Solution
{
public:
    bool isValid(string s)
    {
        int i;
        int n = s.size();
        stack<char> k;
        unordered_map<char, char> m = {{'(', ')'}, {'[', ']'}, {'{', '}'}};
        for (i = 0; i < n; i++)
        {
            char c = s[i];
            if (c == '[' || c == '(' || c == '{')
                k.push(c);
            else
            {
                if (k.empty())
                    return false;
                if (c != m[k.top()])
                    return false;
                k.pop();
            }
        }
        return k.empty();
    }
};

int main()
{
    Solution s;
    cout<<s.isValid("()");
}