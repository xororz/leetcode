package main

import "strconv"

func getHint(secret string, guess string) string {
	m := make(map[byte]int)
	a, b := 0, 0
	for i := range secret {
		m[secret[i]]++
		if guess[i] == secret[i] {
			a++
			m[secret[i]]--
		}
	}
	for i := range secret {
		if !(guess[i] == secret[i]) {
			if m[guess[i]] > 0 {
				b++
				m[guess[i]]--
			}
		}
	}
	return strconv.Itoa(a) + "A" + strconv.Itoa(b) + "B"
}
