impl Solution {
    pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
        let n=nums.len();
        let mut left=1;
        let mut right=1;
        let mut dup=nums[0]-1;
        while right<n{
            if nums[right]!=dup{
                nums[left]=nums[right];
                if nums[left]==nums[left-1]{
                    dup=nums[left];
                }
                left+=1;
            }
            right+=1;
        }
        left as i32
    }
}