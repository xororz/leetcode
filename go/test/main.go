package main

import "sort"

func search(nums []int, target int) int {
	n := len(nums)
	r := sort.Search(n, func(i int) bool {
		return nums[i] < nums[0]
	})
	if r == n {
		idx := sort.Search(n, func(i int) bool {
			return nums[i] >= target
		})
		if idx == n {
			return -1
		}
		if nums[idx] == target {
			return idx
		} else {
			return -1
		}
	} else {
		idx1 := sort.Search(r, func(i int) bool {
			return nums[i] >= target
		})
		if nums[idx1] == target {
			return idx1
		}
		idx2 := sort.Search(n-r, func(i int) bool {
			return nums[i+r] >= target
		})
		idx2 += r
		if idx2 == n {
			return -1
		} else {
			if nums[idx2] == target {
				return idx2
			} else {
				return -1
			}
		}
	}
}

func main() {
	search([]int{1}, 2)
}
