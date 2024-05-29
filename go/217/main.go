package main

import "fmt"

func containsDuplicate(nums []int) bool {
	m := make(map[int]bool)
	for _, num := range nums {
		ok := m[num]
		m[num] = true
		if ok {
			return true
		}
	}
	return false
}

func main() {
	nums := []int{1, 2, 3, 1}
	fmt.Println(containsDuplicate(nums))
}
