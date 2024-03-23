class Solution
{
public:
    int maxArea(vector<int> &height)
    {
        int i = 0, j = height.size() - 1;
        int best = 0;
        int area = 0;
        while (i < j)
        {
            if (height[i] < height[j])
            {
                area = height[i] * (j - i);
                i++;
            }
            else
            {
                area = height[j] * (j - i);
                j--;
            }
            best = max(area, best);
        }
        return best;
    }
};