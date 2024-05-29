package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func invertTree(root *TreeNode) *TreeNode {
	if root != nil {
		tmp := invertTree(root.Right)
		root.Right = invertTree(root.Left)
		root.Left = tmp
	}
	return root
}

func main() {
	invertTree(nil)
}
