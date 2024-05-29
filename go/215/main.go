package main

func findKthLargest(nums []int, k int) int {
	n := len(nums)
	if n == 1 {
		return nums[0]
	}
	partition := nums[0]
	l, r := -1, n
	for l < r {
		for l++; nums[l] < partition; l++ {
		}
		for r--; nums[r] > partition; r-- {
		}
		if l < r {
			nums[l], nums[r] = nums[r], nums[l]
		}
	}
	if n-r <= k {
		return findKthLargest(nums[:r+1], k-n+r+1)
	} else {
		return findKthLargest(nums[r+1:], k)
	}
}

func main() {
	nums := []int{7, 6, 5, 4, 3, 2, 1}
	print(findKthLargest(nums, 5))
}
