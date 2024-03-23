#include <iostream>
#include <bits/stdc++.h>

using namespace std;

class Solution
{
public:
    unordered_map<char, string> m = {
        {'2', "abc"},
        {'3', "def"},
        {'4', "ghi"},
        {'5', "jkl"},
        {'6', "mno"},
        {'7', "pqrs"},
        {'8', "tuv"},
        {'9', "wxyz"},
    };
    vector<string> letterCombinations(string digits)
    {
        vector<char> arr;
        int n = digits.size();
        vector<string> ans;
        if(n==0)return ans;
        for (int i = 0; i < n; i++)
        {
            arr.push_back(digits[i]);
        }
        // permulations(ans, arr, 0);

        gen_str(ans,arr,0,"");
        return ans;
    }
    void permulations(vector<string> &ans, vector<char> &arr, int start)
    {
        // unordered_set<char> set;
        // if (start == arr.size())
        // {
        //     gen_str(ans, arr, 0, "");
        //     return;
        // }
        // for (int i = start; i < arr.size(); i++)
        // {
        //     if (set.find(arr[i]) != set.end())
        //         continue;
        //     set.insert(arr[i]);
        //     swap(arr[start], arr[i]);
        //     permulations(ans, arr, start + 1);
        //     swap(arr[start], arr[i]);
        // }
        gen_str(ans,arr,0,"");
    }
    void gen_str(vector<string> &ans, vector<char> &arr, int start, string tmp)
    {
        if (start == arr.size())
        {
            ans.push_back(tmp);
            return;
        }
        string now = (this->m)[arr[start]];
        for (int i = 0; i < now.size(); i++)
        {
            gen_str(ans, arr, start + 1, tmp + now.substr(i, 1));
        }
    }
};

int main()
{
    Solution s;
    vector<string>out=s.letterCombinations("232323");
    for(string t:out)cout<<t;
}