package main

func majorityElement(nums []int) []int {
	c := make(map[int]int)
	for _, num := range nums {
		c[num] = c[num] + 1
	}
	res := make([]int, 0)
	for num := range c {
		if c[num] > len(nums)/3 {
			res = append(res, num)
		}
	}
	return res
}
