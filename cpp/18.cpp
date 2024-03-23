#include <bits/stdc++.h>

using namespace std;
class Solution
{
public:
    vector<vector<int>> fourSum(vector<int> &nums, int target)
    {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int a, b, c, d;
        int la, lb, lc, ld;
        bool first = true;
        vector<vector<int>> ans;
        for (a = 0; a < n - 3; a++)
        {
            if (first)
            {
                la = nums[a];
            }
            else
            {
                if (la == nums[a])
                    continue;
                la = nums[a];
            }
            first = true;
            for (b = a + 1; b < n - 2; b++)
            {
                if (first)
                {
                    lb = nums[b];
                }
                else
                {
                    if (lb == nums[b])
                        continue;
                    lb = nums[b];
                }
                c = b + 1;
                d = n - 1;
                first = true;
                while (c < d)
                {
                    if (first)
                    {
                        lc = nums[c];
                        first = false;
                    }
                    else
                    {
                        if (lc == nums[c] && c != b + 1)
                        {
                            c++;
                            continue;
                        }

                            // int s = nums[a] + nums[b] + nums[c] + nums[d];
                            long s = (long)nums[a] + (long)nums[b] + (long)nums[c] + (long)nums[d];
                            if (s > target)
                            {
                                d--;
                            }
                            if (s == target)
                            {
                                ans.push_back({nums[a], nums[b], nums[c], nums[d]});
                                lc = nums[c];
                                c++;
                            }
                            if (s < target)
                            {
                                lc = nums[c];
                                c++;
                            }
                        }
                    }
                }
                return ans;
            }
        };

        int main()
        {
            Solution a;
            // vector<int> input = {1, 0, -1, 0, -2, 2};
            // [-3,-2,-1,0,0,1,2,3]
            vector<int> input = {-3, -2, -1, 0, 0, 1, 2, 3};
            vector<vector<int>> ans = a.fourSum(input, 0);
            for (auto i : ans)
            {
                for (auto j : i)
                {
                    cout << j << " ";
                }
                cout << endl;
            }
            return 0;
        }
        cout << j << " ";
    }
    cout << endl;
} return 0;
