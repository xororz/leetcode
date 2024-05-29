package main

func findDuplicate(nums []int) int {
	m := make(map[int]int)
	for _, num := range nums {
		m[num]++
	}
	for num := range m {
		if m[num] > 1 {
			return num
		}
	}
	return 0
}
