package main

import (
	"fmt"
	"math"
)

func calculate(s string) int {
	nums := make([]int, 0)
	ops := make([]byte, 0)
	last_is_num := false
	neg_flag := false
	pri := make(map[byte]int)
	pri['+'] = 1
	pri['-'] = 1
	pri['*'] = 2
	pri['/'] = 2
	pri['^'] = 3
	for i := 0; i < len(s); i++ {
		if s[i] == ' ' {
			continue
		}
		c := s[i]
		if '0' <= c && c <= '9' {
			if last_is_num {
				last_num := nums[len(nums)-1]
				nums[len(nums)-1] = last_num*10 + int(c-'0')
			} else {
				nums = append(nums, int(c-'0'))
				last_is_num = true
			}
		} else {
			op := s[i]
			if op == '(' {
				res := calculate(s[i+1:])
				nums = append(nums, res)
				last_is_num = true
				count := 1
				for j := i + 1; j < len(s); j++ {
					if s[j] == '(' {
						count++
					}
					if s[j] == ')' {
						count--
					}
					if count == 0 {
						i = j
						break
					}
				}
				continue
			}
			if op == ')' {
				return cal(nums, ops, pri)
			}
			if neg_flag {
				nums[len(nums)-1] *= -1
				neg_flag = false
				continue
			}
			if (len(nums) == 0 && op == '-') || !last_is_num {
				neg_flag = true
				last_is_num = false
				continue
			}
			if len(ops) == 0 {
				ops = append(ops, op)
			} else {
				last_op := ops[len(ops)-1]
				if pri[op] < pri[last_op] {
					for j := len(ops) - 1; j >= 0; j-- {
						if pri[ops[j]] <= pri[op] {
							nums[j+1] = cal(nums[j+1:], ops[j+1:], pri)
							nums = nums[:j+2]
							ops = ops[:j+1]
							break
						}
					}
				}
				ops = append(ops, op)

			}
			last_is_num = false
		}
	}
	return cal(nums, ops, pri)
}

func cal(nums []int, ops []byte, pri map[byte]int) int {
	for len(ops) > 0 {
		if len(ops) > 1 {
			if pri[ops[1]] > pri[ops[0]] {
				nums[1] = cal(nums[1:], ops[1:], pri)
				nums = nums[:2]
				ops = ops[:1]
			}
		}
		// fmt.Printf("%d %c %d = ", nums[0], ops[0], nums[1])
		switch ops[0] {
		case '+':
			nums[1] = nums[0] + nums[1]
		case '-':
			nums[1] = nums[0] - nums[1]
		case '*':
			nums[1] = nums[0] * nums[1]
		case '/':
			nums[1] = nums[0] / nums[1]
		case '^':
			nums[1] = int(math.Pow(float64(nums[0]), float64(nums[1])))
		}
		nums = nums[1:]
		ops = ops[1:]
		// fmt.Println(nums[0])
	}
	return nums[0]
}

func main() {
	s := "1+2-(2*3)^4/(4*2-9)"
	fmt.Println(calculate(s))
}
