package main

import (
	"fmt"
	"strconv"
)

func diffWaysToCompute(expression string) []int {
	nums := []int{}
	ops := []byte{}
	i, j := 0, 0
	for i < len(expression) {
		flag := false
		if j == len(expression) {
			flag = true
		} else if !('0' <= expression[j] && expression[j] <= '9') {
			flag = true
		}
		if flag {
			num, _ := strconv.Atoi(expression[i:j])
			nums = append(nums, num)
			if j < len(expression) {
				ops = append(ops, expression[j])
			}
			i = j + 1
		}
		j++
	}
	cache := make(map[int][]int)
	return cal(nums, ops, 0, len(nums)-1, cache)
}

func cal(nums []int, ops []byte, start, end int, cache map[int][]int) []int {
	res := []int{}
	if start == end {
		res = append(res, nums[start])
		return res
	}
	if start+1 == end {
		res = append(res, basecal(nums[start], nums[end], ops[start]))
		return res
	} else {
		c, ok := cache[start*20+end]
		if ok {
			return c
		}
		for i := start; i < end; i++ {
			p1 := cal(nums, ops, start, i, cache)
			p2 := cal(nums, ops, i+1, end, cache)
			for _, num1 := range p1 {
				for _, num2 := range p2 {
					res = append(res, basecal(num1, num2, ops[i]))
				}
			}
		}
		cache[start*20+end] = res
		return res
	}
}

func basecal(num1, num2 int, ops byte) int {
	switch ops {
	case '+':
		return num1 + num2
	case '-':
		return num1 - num2
	case '*':
		return num1 * num2

	}
	return 0
}

func main() {
	fmt.Print(diffWaysToCompute("1-2+3-4"))
}
