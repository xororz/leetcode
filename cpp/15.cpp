#include <iostream>
#include <bits/stdc++.h>

using namespace std;

class Solution
{
public:
    vector<vector<int>> threeSum(vector<int> &nums)
    {
        int len = nums.size();
        sort(nums.begin(), nums.end());
        int i, j, k;
        vector<vector<int>> ans;
        int lasti=999999, lastj=999999;
        for (i = 0; i < len - 2; i++)
        {
            if (nums[i] == lasti)
                continue;
            j = i + 1;
            k = len - 1;
            lastj=999999;
            while (k > j)
            {
                int sum3 = nums[i] + nums[j] + nums[k];
                if (sum3 > 0)
                    k--;
                else
                {
                    if (sum3 < 0)
                    {
                        lastj = nums[j];
                        j++;
                    }
                    else
                    {
                        if (lastj == nums[j])
                        {
                            j++;
                            continue;
                        }
                        ans.push_back({nums[i], nums[j], nums[k]});
                        lastj = nums[j];
                        j++;
                    }
                }
            }
            lasti = nums[i];
        }
        return ans;
    }
};