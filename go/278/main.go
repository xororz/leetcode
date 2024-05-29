package main

import "sort"

func isBadVersion(version int) bool

func firstBadVersion(n int) int {
	return sort.Search(n, func(i int) bool { return isBadVersion(i + 1) }) + 1
}
