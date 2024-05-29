package main

type pair struct {
	index int
	val   int
}

func containsNearbyAlmostDuplicate(nums []int, indexDiff int, valueDiff int) bool {
	minval := int(2e9)
	for _, num := range nums {
		minval = min(minval, num)
	}
	m := make(map[pair]pair)
	for i, num := range nums {
		tmp := new(pair)
		tmp.index = i / indexDiff
		tmp.val = (num - minval) / (valueDiff + 1)
		item := new(pair)
		item.index = i
		item.val = num
		_, ok := m[*tmp]
		if ok {
			return true
		} else {
			m[*tmp] = *item
		}
	}
	for key := range m {
		for i := -1; i < 2; i++ {
			for j := -1; j < 2; j++ {
				if i != 0 || j != 0 {
					tmp := new(pair)
					tmp.index = key.index + i
					tmp.val = key.val + j
					_, ok := m[*tmp]
					if ok {
						v1 := m[*tmp]
						v2 := m[key]
						if -indexDiff <= v1.index-v2.index && v1.index-v2.index <= indexDiff {
							if -valueDiff <= v1.val-v2.val && v1.val-v2.val <= valueDiff {
								return true
							}
						}
					}
				}
			}
		}
	}
	return false
}

func main() {
	print(containsNearbyAlmostDuplicate([]int{1, 2, 3}, 1, 0))
}
