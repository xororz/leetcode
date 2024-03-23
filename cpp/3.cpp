class Solution
{
public:
    int lengthOfLongestSubstring(string s)
    {
        map<char, int> m;
        int next[s.size()];
        int maxlen = 0;
        int length = 0;
        for (int i = s.size() - 1; i >= 0; i--)
        {
            if (m.find(s[i]) == m.end())
            {
                next[i] = 99;
                m[s[i]] = i;
            }
            else
            {
                next[i] = m[s[i]] - i;
                m[s[i]] = i;
            }
            length = min(next[i], length + 1);
            maxlen = max(maxlen, length);
        }
        return maxlen;
    }
};