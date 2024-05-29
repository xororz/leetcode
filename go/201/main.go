package main

import "fmt"

func rangeBitwiseAnd(left int, right int) int {
	var res = 0
	for i := 0; i < 31; i++ {
		res <<= 1
		if left>>(30-i) == right>>(30-i) && left>>(30-i)&1 > 0 {
			res += 1
		}
	}
	return res
}

func main() {
	fmt.Print(rangeBitwiseAnd(2, 2))
}
