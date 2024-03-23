class Solution
{
public:
    double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2)
    {
        int total = nums1.size() + nums2.size();
        int half = total / 2;
        if (total % 2 != 0)
        {
            half++;
        }
        if (nums1.size() == 0)
        {
            if (total % 2 == 0)
            {
                return (nums2[half - 1] + nums2[half]) / 2.0;
            }
            else
            {
                return nums2[half - 1];
            }
        }
        if (nums2.size() == 0)
        {
            if (total % 2 == 0)
            {
                return (nums1[half - 1] + nums1[half]) / 2.0;
            }
            else
            {
                return nums1[half - 1];
            }
        }
        int i = 0, j = 0;
        if (nums1.size() > nums2.size())
        {
            swap(nums1, nums2);
        }
        int left = 0, right = nums1.size();
        while (left <= right)
        {
            i = (left + right) / 2;
            j = half - i;
            if (i == 0 || j == nums2.size())
            {
                if (nums1[i] < nums2[j - 1])
                {
                    left = i + 1;
                }
                else
                {
                    break;
                }
            }
            else if (j == 0 || i == nums1.size())
            {
                if (nums1[i - 1] > nums2[j])
                {
                    right = i - 1;
                }
                else
                {
                    break;
                }
            }
            else if (nums1[i - 1] > nums2[j])
            {
                right = i - 1;
            }
            else if (nums1[i] < nums2[j - 1])
            {
                left = i + 1;
            }
            else
            {
                break;
            }
        }
        if (total % 2 == 0)
        {
            int mid1 = 0, mid2 = 0;
            if (i == 0)
            {
                mid1 = nums2[j - 1];
                if (j == nums2.size())
                    mid2 = nums1[i];
                else
                    mid2 = min(nums1[i], nums2[j]);
            }
            else if (j == 0)
            {
                mid1 = nums1[i - 1];
                if (i == nums1.size())
                    mid2 = nums2[j];
                else
                    mid2 = min(nums1[i], nums2[j]);
            }
            else if (i == nums1.size())
            {
                mid1 = max(nums1[i - 1], nums2[j - 1]);
                mid2 = nums2[j];
            }
            else if (j == nums2.size())
            {
                mid1 = max(nums1[i - 1], nums2[j - 1]);
                mid2 = nums1[i];
            }
            else
            {
                mid1 = max(nums1[i - 1], nums2[j - 1]);
                mid2 = min(nums1[i], nums2[j]);
            }
            return (mid1 + mid2) / 2.0;
        }
        else
        {
            if (i == 0)
            {
                return nums2[j - 1];
            }
            else if (j == 0)
            {
                return nums1[i - 1];
            }
            else
            {
                return max(nums1[i - 1], nums2[j - 1]);
            }
        }
    }
};