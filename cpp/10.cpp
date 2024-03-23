#include <iostream>
#include <bits/stdc++.h>

using namespace std;

class Solution
{
public:
    bool isMatch(string s, string p)
    {
        int s_len = s.size();
        int p_len = p.size();
        int i, j;
        vector<string> ps = vector<string>();
        for (i = 0; i < p_len - 1; i++)
        {
            if (p[i] == '*')
                continue;
            if (p[i + 1] != '*')
                ps.push_back(p.substr(i, 1));
            else
                ps.push_back(p.substr(i, 2));
        }
        if (p[i] != '*')
            ps.push_back(p.substr(i, 1));
        int ps_len = ps.size();
        bool m[s_len + 1][ps_len + 1];
        // if (!match(s[0], ps[0]))
        //     return false;

        for (i = 0; i < s_len + 1; i++)
            for (j = 0; j < ps_len + 1; j++)
                m[i][j] = false;
        m[0][0] = true;
        for (i = 1; i < ps_len + 1; i++)
        {
            if (m[0][i - 1] && ps[i - 1].size() == 2)
                m[0][i] = true;
            else
                break;
        }
        int x, y;
        for (x = 0; x < s_len; x++)
            for (y = 0; y < ps_len; y++)
            {
                i = x + 1;
                j = y + 1;
                if (match(s[i - 1], ps[j - 1]) && ps[j - 1].size() == 2 && m[i - 1][j])
                {

                    m[i][j] = true;
                    continue;
                }
                if (j >= 1 && match(s[i - 1], ps[j - 1]) && m[i - 1][j - 1])
                {
                    m[i][j] = true;
                    continue;
                }
                if (j >= 1 && ps[j - 1].size() == 2 && m[i][j - 1])
                {
                    m[i][j] = true;
                    continue;
                }
                m[i][j] = false;
            }
        return m[s_len][ps_len];
    }
    bool match(char c, string p)
    {
        if (p[0] == '.')
            return true;
        if (p[0] != c)
            return false;
        return true;
    }
};
int main()
{
    Solution s = Solution();
    cout << s.isMatch("aa", "a");
}