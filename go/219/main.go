package main

func containsNearbyDuplicate(nums []int, k int) bool {
	m := make(map[int][]int)
	for i, num := range nums {
		_, ok := m[num]
		if ok {
			m[num] = append(m[num], i)
		} else {
			m[num] = []int{i}
		}
	}
	for key := range m {
		for i := 0; i < len(m[key])-1; i++ {
			if m[key][i+1]-m[key][i] <= k {
				return true
			}
		}
	}
	return false
}

func main() {
	print(containsNearbyDuplicate([]int{1, 4, 8, 1}, 2))
}
