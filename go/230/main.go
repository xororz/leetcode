package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func count(root *TreeNode) int {
	if root == nil {
		return 0
	}
	return 1 + count(root.Left) + count(root.Right)
}

func kthSmallest(root *TreeNode, k int) int {
	l := count(root.Left)
	if k == l+1 {
		return root.Val
	} else if k > l+1 {
		return kthSmallest(root.Right, k-l-1)
	} else {
		return kthSmallest(root.Left, k)
	}
}
