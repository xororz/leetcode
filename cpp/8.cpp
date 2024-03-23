class Solution
{
public:
    int myAtoi(string s)
    {
        bool start = true;
        int len = s.size();
        int ans = 0;
        int flag = 1;
        bool nextisnum = false;
        bool noflag = false;
        for (int i = 0; i < len; i++)
        {
            char c = s[i];
            if (c == ' ' && start)
                continue;
            start = false;
            if (!nextisnum && !noflag)
            {

                if (c == '-')
                {
                    flag = -1;
                    nextisnum = true;
                    continue;
                }
                if (c == '+')
                {
                    nextisnum = true;
                    continue;
                }
            }
            if ('0' <= c && c <= '9')
            {
                noflag = true;
                if (ans > 214748364)
                {
                    return 2147483647;
                }
                if (ans < -214748364)
                {
                    return -2147483648;
                }
                if (ans == 214748364)
                {
                    if (c - '0' > 7)
                        return 2147483647;
                }
                if (ans == -214748364)
                {
                    if (c - '0' > 8)
                        return -2147483648;
                }
                ans *= 10;
                ans += flag * (c - '0');
            }
            else
            {
                if (ans == 0)
                    return 0;
                else
                    return ans;
            }
        }
        return ans;
    }
};