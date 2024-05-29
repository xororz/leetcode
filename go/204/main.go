package main

import "math"

func countPrimes(n int) int {
	if n < 2 {
		return 0
	}
	n--
	m := make([]bool, n)
	for i := 1; i < n; i++ {
		m[i] = true
	}
	base := int(math.Sqrt(float64(n)))
	for i := 2; i <= base; i++ {
		if !m[i-1] {
			continue
		}
		if isPrime(i) {
			for j := 2 * i; j <= n; j += i {
				m[j-1] = false
			}
		}
	}
	res := 0
	for i := 0; i < n; i++ {
		if m[i] {
			res++
		}
	}
	return res
}

func isPrime(n int) bool {
	base := int(math.Sqrt(float64(n)))
	for i := 2; i <= base; i++ {
		if n%i == 0 {
			return false
		}
	}
	return true
}

func main() {
	print(countPrimes(2))
}
