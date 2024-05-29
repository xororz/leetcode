package main

import "fmt"

func isHappy(n int) bool {
	var m [1000]bool
	for {
		if n > 1000 {
			n = q(n)
		} else {
			if m[n] {
				return false
			}
			if n == 1 {
				break
			}
			m[n] = true
			n = q(n)
		}
	}
	return true
}

func q(n int) int {
	res := 0
	for n > 0 {
		res += (n % 10) * (n % 10)
		n /= 10
	}
	return res
}

func main() {
	fmt.Println(isHappy(19))
}
