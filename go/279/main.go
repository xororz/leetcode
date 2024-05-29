package main

import "math"

var cache = make(map[int]int)

func numSquares(n int) int {
	if cache[n] > 0 {
		return cache[n]
	}
	if n == 1 {
		return 1
	}
	s := int(math.Sqrt(float64(n)))
	if s*s == n {
		return 1
	}
	res := 99999
	for i := 1; i <= s; i++ {
		res = min(res, numSquares(n-i*i)+1)
	}
	cache[n] = res
	return res
}

func main() {
	numSquares(12)
}
