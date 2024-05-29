package main

func rob(nums []int) int {
	n := len(nums)
	if n == 1 {
		return nums[0]
	}
	if n == 2 {
		return max(nums[0], nums[1])
	}
	return max(nums[0]+normalrob(nums[2:len(nums)-1]), nums[len(nums)-1]+normalrob(nums[1:len(nums)-2]), normalrob(nums[1:len(nums)-1]))
}

func normalrob(nums []int) int {
	n := len(nums)
	res := make([]int, n)
	if n == 0 {
		return 0
	}
	if n == 1 {
		return nums[0]
	}
	if n == 2 {
		return max(nums[0], nums[1])
	}
	if n == 3 {
		return max(nums[0]+nums[2], nums[1])
	}
	res[0] = nums[0]
	res[1] = nums[1]
	res[2] = nums[2] + nums[0]
	for i := 3; i < n; i++ {
		res[i] = nums[i] + max(res[i-2], res[i-3])
	}
	m := 0
	for i := 0; i < n; i++ {
		if res[i] > m {
			m = res[i]
		}
	}
	return m
}

func main() {
	nums := []int{2, 3, 2}
	print(rob(nums))
}
