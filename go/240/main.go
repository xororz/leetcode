package main

func searchMatrix(matrix [][]int, target int) bool {
	for i := range matrix {
		nums := matrix[i]
		if search(nums, target) {
			return true
		}
	}
	return false
}

func search(nums []int, target int) bool {
	l, r := 0, len(nums)-1
	for l <= r {
		mid := (l + r) / 2
		if nums[mid] == target {
			return true
		}
		if nums[mid] > target {
			r = mid - 1
		} else {
			l = mid + 1
		}
	}
	return false
}
