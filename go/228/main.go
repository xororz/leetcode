package main

import "fmt"

func summaryRanges(nums []int) []string {
	res := make([]string, 0)
	if len(nums) == 0 {
		return make([]string, 0)
	}
	nums = append(nums, nums[len(nums)-1]-1)
	start, end := nums[0], 0
	for i, num := range nums[:len(nums)-1] {
		if num == nums[i+1] {
			continue
		}
		if num+1 != nums[i+1] {
			end = num
			if start == end {
				res = append(res, fmt.Sprintf("%d", num))
			} else {
				res = append(res, fmt.Sprintf("%d->%d", start, end))
			}
			start = nums[i+1]
		}
	}
	return res
}

func main() {
	fmt.Println(summaryRanges([]int{1, 2, 4, 4, 6, 7, 9}))
}
