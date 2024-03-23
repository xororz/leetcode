class Solution
{
public:
    int reverse(int x)
    {
        int flag = 1;
        if (x == -2147483648)
            return 0;
        if (x < 0)
        {
            flag = -1;
            x = -x;
        }
        int ans = 0;
        while (x != 0)
        {
            if (ans > 214748364)
                return 0;
            {

                ans *= 10;
                ans += x % 10;
                x /= 10;
            }
        }
        if (flag == -1)
            return -ans;
        return ans;
    }
};