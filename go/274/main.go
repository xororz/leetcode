package main

import "sort"

func hIndex(citations []int) (res int) {
	sort.Slice(citations, func(i, j int) bool {
		return citations[i] > citations[j]
	})
	res = len(citations)
	for i, num := range citations {
		if num < i+1 {
			res = i
			break
		}
	}
	return
}
