#include <iostream>
#include <bits/stdc++.h>

using namespace std;

class Solution
{
public:
    int romanToInt(string s)
    {
        unordered_map<string, int> m = {
            {"I", 1}, {"II", 2}, {"III", 3}, {"IV", 4}, {"V", 5}, {"VI", 6}, {"VII", 7}, {"VIII", 8}, {"IX", 9}, {"X", 10}, {"XX", 20}, {"XXX", 30}, {"XL", 40}, {"L", 50}, {"LX", 60}, {"LXX", 70}, {"LXXX", 80}, {"XC", 90}, {"C", 100}, {"CC", 200}, {"CCC", 300}, {"CD", 400}, {"D", 500}, {"DC", 600}, {"DCC", 700}, {"DCCC", 800}, {"CM", 900}, {"M", 1000}, {"MM", 2000}, {"MMM", 3000}};
        int ans = 0;
        int i = 0, size = 1;
        int len = s.size();
        while (i < len)
        {
            while (m.find(s.substr(i, size)) != m.end())
            {
                if (i + size == len)
                {
                    ans += m[s.substr(i, size)];
                    return ans;
                }
                size++;
            }
            size -= 1;
            ans += m[s.substr(i, size)];
            i += size;
            size = 1;
        }
        return ans;
    }
};
int main()
{
    Solution s;
    cout << s.romanToInt("IV");
}