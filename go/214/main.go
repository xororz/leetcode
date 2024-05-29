package main

import "fmt"

func shortestPalindrome(s string) string {
	n := len(s)
	if n == 1 {
		return s
	}
	n2 := n / 2
	p := s[:n2]
	reversed := []rune(s)
	for i := 0; i < n2; i++ {
		reversed[i], reversed[n-1-i] = reversed[n-1-i], reversed[i]
	}
	rev := string(reversed)
	l := kmp(rev, p)
	return rev[:n-l] + s
}

func gennext(p string) []int {
	if len(p) < 2 {
		return make([]int, len(p))
	}
	next := make([]int, 1)
	for i := 1; i < len(p); i++ {
		if p[i] == p[next[i-1]] {
			next = append(next, next[i-1]+1)
		} else {
			if next[i-1] == 0 {
				next = append(next, 0)
			} else {
				next = append(next, next[next[i-1]-1])
				if p[i] == p[next[i-1]-1] {
					next[len(next)-1] += 1
				}
			}
		}
	}
	return next
}

func kmp(s string, p string) int {
	next := gennext(p)
	m, n := len(s), len(p)
	i, j := 0, 0
	res := 0
	for i < m {
		if s[i] == p[j] {
			i++
			j++
			if i+j >= m-1 {
				res = max(res, m-i+j)
			}
			if j == n {
				fmt.Println("match")
				fmt.Println(i)
				j = next[j-1]
			}
		} else {
			if j != 0 {
				j = next[j-1]
			} else {
				i++
			}
		}
	}
	return res
}

func main() {
	kmp("ababbabbbab", "babbb")
	print(shortestPalindrome("babbbabbaba"))
}
