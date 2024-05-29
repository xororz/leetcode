package main

import "fmt"

func combinationSum3(k int, n int) [][]int {
	res := make([][]int, 0)
	path := make([]int, 0)
	dfs(k, n, 1, &path, &res)
	return res
}

func dfs(k int, n int, start int, path *[]int, res *[][]int) {
	if k == 0 && n == 0 {
		tmp := append([]int(nil), *path...)
		*res = append(*res, tmp)
	}
	if k == 0 || n < 0 {
		return
	}
	for i := start; i < 10; i++ {
		*path = append(*path, i)
		dfs(k-1, n-i, i+1, path, res)
		*path = (*path)[:len(*path)-1]
	}
}

func main() {
	fmt.Println(combinationSum3(3, 10))
}
