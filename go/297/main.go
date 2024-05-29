package main

import (
	"strconv"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

type Codec struct {
}

func Constructor() Codec {
	return *new(Codec)
}

// Serializes a tree to a single string.
func (this *Codec) serialize(root *TreeNode) string {
	if root == nil {
		return "n,"
	}
	res := []byte{}
	q1, q2 := []*TreeNode{root}, []*TreeNode{}
	for len(q1) > 0 {
		for i := 0; i < len(q1); i++ {
			if q1[i] != nil {
				res = strconv.AppendInt(res, int64(q1[i].Val), 10)
				res = append(res, ',')
				q2 = append(q2, q1[i].Left, q1[i].Right)
			} else {
				res = append(res, 'n', ',')
			}
		}
		q1 = q2
		q2 = []*TreeNode{}
	}
	return string(res)
}

func makenode(data string) *TreeNode {
	if data[0] == 'n' {
		return nil
	}
	t := new(TreeNode)
	t.Left = nil
	t.Right = nil
	t.Val, _ = strconv.Atoi(data)
	return t
}

// Deserializes your encoded data to tree.
func (this *Codec) deserialize(data string) *TreeNode {
	i, j := 0, 0
	nodes := []*TreeNode{}
	for j < len(data) {
		if data[j] == ',' {
			node := makenode(data[i:j])
			nodes = append(nodes, node)
			i = j + 1
		}
		j++
	}
	if data[0] == 'n' {
		return nil
	}
	idx := 1
	root := nodes[0]
	q1, q2 := []*TreeNode{root}, []*TreeNode{}
	for len(q1) > 0 {
		if idx == len(nodes) {
			return root
		}
		for i := 0; i < len(q1); i++ {
			q1[i].Left = nodes[idx]
			if nodes[idx] != nil {
				q2 = append(q2, nodes[idx])
			}
			idx++
			q1[i].Right = nodes[idx]
			if nodes[idx] != nil {
				q2 = append(q2, nodes[idx])
			}
			idx++
		}
		q1 = q2
		q2 = []*TreeNode{}
	}
	return root
}

func main() {
	tool := Constructor()
	tmp := tool.serialize(tool.deserialize("1,2,3,n,n,4,5,"))
	tool.deserialize(tmp)
}
