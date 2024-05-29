package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func removeElements(head *ListNode, val int) *ListNode {
	if head == nil {
		return head
	}
	dummy := new(ListNode)
	dummy.Next = head
	pre, now := dummy, dummy.Next
	for now != nil {
		if now.Val == val {
			pre.Next = now.Next
			now = now.Next
			continue
		}
		pre, now = pre.Next, now.Next
	}
	return dummy.Next
}

func main() {
	removeElements(nil, 0)
}
