class Solution
{
public:
    string convert(string s, int numRows)
    {
        if (numRows == 1)
            return s;
        unordered_map<int, vector<char>> m;
        for (int i = 0; i < numRows; i++)
            m[i] = vector<char>();
        int len = s.size();
        int loc = 0;
        int v = 1;
        for (int i = 0; i < len; i++)
        {
            if (loc == 0 && v == -1)
            {
                v = 1;
            }
            else if (loc == numRows - 1 && v == 1)
            {
                v = -1;
            }
            m[loc].push_back(s[i]);
            loc += v;
        }
        string ans = "";
        for (int i = 0; i < numRows; i++)
        {
            for (int j = 0; j < m[i].size(); j++)
            {
                ans += m[i][j];
            }
        }
        return ans;
    }
};