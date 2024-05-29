package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func isPalindrome(head *ListNode) bool {

	nums := make([]int, 0)
	tmp := head
	for tmp != nil {
		nums = append(nums, tmp.Val)
		tmp = tmp.Next
	}
	for i := 0; i < len(nums)/2; i++ {
		if nums[i] != nums[len(nums)-i-1] {
			return false
		}
	}
	return true
}
