package main

func wordPattern(pattern string, s string) bool {
	m := make(map[byte]string)
	set := make(map[string]bool)
	i, j := 0, 0
	c := 0
	for j < len(s)+1 {
		flag := false
		if j == len(s) {
			flag = true
		} else if s[j] == ' ' {
			flag = true
		}
		if flag {
			if c >= len(pattern) {
				return false
			}
			word := s[i:j]
			i = j + 1
			w, ok := m[pattern[c]]
			if ok {
				if w != word {
					return false
				}
			} else {
				m[pattern[c]] = word
				if set[word] {
					return false
				}
				set[word] = true
			}
			c++
		}
		j++
	}
	return c == len(pattern)
}
