class Solution
{
public:
    string intToRoman(int num)
    {
        unordered_map<int, string> m = {
            {1, "I"},
            {2, "II"},
            {3, "III"},
            {4, "IV"},
            {5, "V"},
            {6, "VI"},
            {7, "VII"},
            {8, "VIII"},
            {9, "IX"},
            {10, "X"},
            {20, "XX"},
            {30, "XXX"},
            {40, "XL"},
            {50, "L"},
            {60, "LX"},
            {70, "LXX"},
            {80, "LXXX"},
            {90, "XC"},
            {100, "C"},
            {200, "CC"},
            {300, "CCC"},
            {400, "CD"},
            {500, "D"},
            {600, "DC"},
            {700, "DCC"},
            {800, "DCCC"},
            {900, "CM"},
            {1000, "M"},
            {2000, "MM"},
            {3000, "MMM"}};
        string ans = "";
        int base = 1000;
        int k = 10;
        int s = 0;
        while (num)
        {
            s = num / base * base;
            if (s)
            {
                ans += m[s];
            }
            num %= base;
            base /= 10;
        }
        return ans;
    }
};