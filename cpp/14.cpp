class Solution
{
public:
    string longestCommonPrefix(vector<string> &strs)
    {
        int n = strs.size();
        string ans = "";
        int i, j;
        int minlen = __INT32_MAX__;
        for (i = 0; i < n; i++)
        {
            if (minlen > strs[i].size())
                minlen = strs[i].size();
        }
        for (i = 0; i < minlen; i++)
        {
            char tmp = strs[0][i];
            for (j = 1; j < n; j++)
            {
                if (tmp != strs[j][i])
                    return ans;
            }
            ans += tmp;
        }
        return ans;
    }
};