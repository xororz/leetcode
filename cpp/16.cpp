#include <iostream>
#include <bits/stdc++.h>

using namespace std;

class Solution
{
public:
    int threeSumClosest(vector<int> &nums, int target)
    {
        int len = nums.size();
        sort(nums.begin(), nums.end());
        int i, left, right;
        int ans = 0;
        int mindistance = 99999;
        for (i = 0; i < len - 2; i++)
        {
            left = i + 1;
            right = len - 1;
            while (left < right)
            {
                int s = nums[i] + nums[left] + nums[right];
                int dis = s - target;
                if (abs(dis) < mindistance)
                {
                    mindistance = abs(dis);
                    ans = s;
                }
                if (dis > 0)
                {
                    right--;
                }
                else
                {
                    left++;
                }
            }
        }
        return ans;
    }
};

int main()
{
    Solution s;
    vector<int> test = {1, 1, 1, 0};
    cout << s.threeSumClosest(test, -100);
}