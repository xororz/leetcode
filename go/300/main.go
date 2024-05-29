package main

func lengthOfLIS(nums []int) int {
	res := []int{1}
	ans := 1
	for i := 1; i < len(nums); i++ {
		tmp := 1
		for j := 0; j < i; j++ {
			if nums[j] < nums[i] {
				tmp = max(tmp, res[j]+1)
			}
		}
		res = append(res, tmp)
		ans = max(ans, tmp)
	}
	return ans
}
