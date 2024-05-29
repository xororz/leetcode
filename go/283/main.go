package main

func moveZeroes(nums []int) {
	count := 0
	res := []int{}
	for i := range nums {
		if nums[i] == 0 {
			count++
		} else {
			res = append(res, nums[i])
		}
	}
	for i := 0; i < count; i++ {
		res = append(res, 0)
	}
	for i := 0; i < len(nums); i++ {
		nums[i] = res[i]
	}
}
