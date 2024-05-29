package main

import (
	"math"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func getNode(root *TreeNode, height int, num int) bool {
	if root == nil {
		return false
	}
	if height == 1 {
		return true
	}
	half := math.Pow(2, float64(height)-2)
	if num > int(half) {
		return getNode(root.Right, height-1, num-int(half))
	} else {
		return getNode(root.Left, height-1, num)
	}
}
func getHeight(root *TreeNode) int {
	if root == nil {
		return 0
	}
	return getHeight(root.Left) + 1
}

func countNodes(root *TreeNode) int {
	h := getHeight(root)
	if h == 0 {
		return 0
	}
	left, right := 0, int(math.Pow(2, float64(h-1)))
	for left <= right {
		mid := (left + right) / 2
		if getNode(root, h, mid) {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return int(math.Pow(2, float64(h-1))) + right - 1
}

func main() {
	countNodes(nil)
}
