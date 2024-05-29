package main

func minSubArrayLen(target int, nums []int) int {
	var (
		n     = len(nums)
		res   = n
		left  = 0
		right = 0
		sum   = 0
		ok    = false
	)
	for right < n {
		sum += nums[right]
		if sum >= target {
			ok = true
			for sum-nums[left] >= target {
				sum -= nums[left]
				left++
			}
			res = min(res, right-left+1)
		}
		right++
	}
	if !ok {
		return 0
	}
	return res
}

func main() {
	nums := []int{2, 3, 1, 2, 4, 3}
	print(minSubArrayLen(7, nums))
}
