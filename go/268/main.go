package main

func missingNumber(nums []int) int {
	n := len(nums)
	s := n * (n + 1) / 2
	for _, num := range nums {
		s -= num
	}
	return s
}
