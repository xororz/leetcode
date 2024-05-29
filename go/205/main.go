package main

func isIsomorphic(s string, t string) bool {
	m := make(map[rune]byte)
	used := make(map[byte]bool)
	for i, cs := range s {
		ct := t[i]
		cst, ok := m[cs]
		if ok {
			if cst != ct {
				return false
			}
		} else {
			if used[ct] {
				return false
			}
			m[cs] = ct
			used[ct] = true
		}
	}
	return true
}

func main() {
	print(isIsomorphic("badc", "baba"))
}
