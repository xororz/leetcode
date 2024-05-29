package main

package main

import (
	"strconv"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func binaryTreePaths(root *TreeNode) []string {
	res := []string{}
	path := []int{}
	dfs(root, &path, &res)
	return res
}

func dfs(root *TreeNode, path *[]int, res *[]string) {
	*path = append(*path, root.Val)
	if root.Left == nil && root.Right == nil {
		s := strconv.Itoa((*path)[0])
		for _, i := range (*path)[1:] {
			s += "->" + strconv.Itoa(i)
		}
		*res = append(*res, s)
	}
	if root.Left != nil {
		dfs(root.Left, path, res)
		*path = (*path)[:len(*path)-1]
	}
	if root.Right != nil {
		dfs(root.Right, path, res)
		*path = (*path)[:len(*path)-1]
	}
}
