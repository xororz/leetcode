package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	pp := make([]*TreeNode, 0)
	qq := make([]*TreeNode, 0)
	search(root, p, &pp)
	search(root, q, &qq)
	res := pp[0]
	for i := 0; i < min(len(pp), len(qq)); i++ {
		if pp[i] == qq[i] {
			res = pp[i]
		} else {
			break
		}
	}
	return res
}

func search(root, p *TreeNode, path *[]*TreeNode) bool {
	if root == nil {
		return false
	}
	*path = append(*path, root)
	if root == p {
		return true
	}
	if search(root.Left, p, path) {
		return true
	}
	if search(root.Right, p, path) {
		return true
	}
	*path = (*path)[:len(*path)-1]
	return false
}
