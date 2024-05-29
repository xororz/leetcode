package main

func isAnagram(s string, t string) bool {
	d := make(map[byte]int)
	for i := range s {
		d[s[i]] += 1
	}
	for i := range t {
		d[t[i]] -= 1
	}
	for key := range d {
		if d[key] != 0 {
			return false
		}
	}
	return true
}

func main() {
	print(isAnagram("car", "rat"))
}
