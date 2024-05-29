package main

func nthUglyNumber(n int) int {
	dp := []int{1}
	p2, p3, p5 := 0, 0, 0
	for n > 1 {
		n--
		minval := min(dp[p2]*2, dp[p3]*3, dp[p5]*5)
		dp = append(dp, minval)
		if minval == 2*dp[p2] {
			p2++
		}
		if minval == 3*dp[p3] {
			p3++
		}
		if minval == 5*dp[p5] {
			p5++
		}
	}
	return dp[len(dp)-1]
}
