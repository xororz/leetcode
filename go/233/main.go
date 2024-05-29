package main

func countDigitOne(n int) int {
	res := 0
	base := 1
	for n >= base {
		res += base + (n-base)/base/10*base
		if (n-base)%(base*10) < base-1 {
			res += (n-base)%(base*10) - base + 1
		}
		base *= 10
	}
	return res
}

func main() {
	print(countDigitOne(1))
}
