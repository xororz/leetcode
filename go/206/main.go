package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseList(head *ListNode) *ListNode {
	dummy := new(ListNode)
	dummy.Next = nil
	t := head
	for t != nil {
		next := t.Next
		t.Next = dummy.Next
		dummy.Next = t
		t = next
	}
	return dummy.Next
}

func main() {
	reverseList(nil)
}
