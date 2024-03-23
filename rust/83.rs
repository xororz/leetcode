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
    pub fn delete_duplicates(head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        let mut head = head;
        let mut current = &mut head;
        while let Some(node) = current {
            if let Some(next) = &mut node.next {
                if node.val == next.val {
                    node.next = next.next.take();
                } else {
                    current = &mut node.next;
                }
            } else {
                break;
            }
        }
        head
    }
}