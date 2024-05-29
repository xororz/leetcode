package main

func productExceptSelf(nums []int) []int {
	l := make([]int, 0)
	r := make([]int, 0)
	base := 1
	l = append(l, base)
	for i := range nums[:len(nums)-1] {
		base *= nums[i]
		l = append(l, base)
	}
	base = 1
	r = append(r, base)
	for i := range nums[:len(nums)-1] {
		base *= nums[len(nums)-1-i]
		r = append(r, base)
	}
	res := make([]int, 0)
	for i := 0; i < len(nums); i++ {
		res = append(res, l[i]*r[len(nums)-i-1])
	}
	return res
}
