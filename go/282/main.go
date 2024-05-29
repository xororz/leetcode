package main

import "fmt"

func addOperators(num string, target int) []string {
	res := []string{}
	nums := []int{}
	for i := 0; i < len(num); i++ {
		nums = append(nums, int(num[i]-'0'))
	}
	ops := []byte{}
	dfs(&nums, &ops, target, &res)
	return res
}

func dfs(nums *[]int, ops *[]byte, target int, res *[]string) {
	if len(*ops)+1 == len(*nums) {
		newnums := make([]int, 0)
		newnums = append(newnums, *nums...)
		newops := make([]byte, 0)
		newops = append(newops, *ops...)
		if cal(newnums, newops) == target {
			tmp := string((*nums)[0] + '0')
			for i := 0; i < len(*ops); i++ {
				tmp += string((*ops)[i])
				tmp += string((*nums)[i+1] + '0')
			}
			*res = append(*res, tmp)
		}
		return
	}
	*ops = append(*ops, '+')
	dfs(nums, ops, target, res)
	*ops = (*ops)[:len(*ops)-1]
	*ops = append(*ops, '-')
	dfs(nums, ops, target, res)
	*ops = (*ops)[:len(*ops)-1]
	*ops = append(*ops, '*')
	dfs(nums, ops, target, res)
	*ops = (*ops)[:len(*ops)-1]
}

func cal(nums []int, ops []byte) int {
	for i := 0; i < len(ops); i++ {
		if ops[i] == '*' {
			nums[i] = nums[i] * nums[i+1]
			nums = append(nums[:i+1], nums[i+2:]...)
			ops = append(ops[:i], ops[i+1:]...)
			i--
		}
	}
	res := nums[0]
	for i := 0; i < len(ops); i++ {
		if ops[i] == '+' {
			res += nums[i+1]
		} else {
			res -= nums[i+1]
		}
	}
	return res
}

func main() {
	fmt.Println(addOperators("232", 8))
	fmt.Println(addOperators("123", 6))
}
