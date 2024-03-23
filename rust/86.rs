// Definition for singly-linked list.
// #[derive(PartialEq, Eq, Clone, Debug)]
// pub struct ListNode {
//   pub val: i32,
//   pub next: Option<Box<ListNode>>
// }
//
// impl ListNode {
//   #[inline]
//   fn new(val: i32) -> Self {
//     ListNode {
//       next: None,
//       val
//     }
//   }
// }
impl Solution {
    pub fn partition(mut head: Option<Box<ListNode>>, x: i32) -> Option<Box<ListNode>> {
        let mut left = Some(Box::new(ListNode { val: 0, next: None }));
        let mut right = Some(Box::new(ListNode { val: 0, next: None }));
        let mut left_tail = &mut left;
        let mut right_tail = &mut right;
        while let Some(mut node) = head.take() {
            head = node.next.take();
            if node.val < x {
                left_tail.as_mut().unwrap().next = Some(node);
                left_tail = &mut left_tail.as_mut().unwrap().next;
            } else {
                right_tail.as_mut().unwrap().next = Some(node);
                right_tail = &mut right_tail.as_mut().unwrap().next;
            }
        }
        left_tail.as_mut().unwrap().next = right.unwrap().next.take();
        left.unwrap().next.take()
    }
}