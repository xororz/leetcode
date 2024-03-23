class Solution
{
public:
    string longestPalindrome(string s)
    {
        int len = s.size();
        int maxlen = 0;
        int maxleft = 0;
        int maxright = 0;
        for (int i = 0; i < len; i++)
        {
            int left = i, right = i;
            while (left >= 0 && right < len && s[left] == s[right])
            {
                left--;
                right++;
            }
            if (right - left - 1 > maxlen)
            {
                maxlen = right - left - 1;
                maxleft = left + 1;
                maxright = right - 1;
            }
            if (i == len - 1)
                break;
            if (s[i] != s[i + 1])
                continue;
            left = i, right = i + 1;
            while (left >= 0 && right < len && s[left] == s[right])
            {
                left--;
                right++;
            }
            if (right - left - 1 > maxlen)
            {
                maxlen = right - left - 1;
                maxleft = left + 1;
                maxright = right - 1;
            }
        }
        string ans = s.substr(maxleft, maxright - maxleft + 1);
        return ans;
    }
};