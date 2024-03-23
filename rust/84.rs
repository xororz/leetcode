impl Solution {
    pub fn largest_rectangle_area(heights: Vec<i32>) -> i32 {
        let mut stack = vec![];
        let mut max_area = 0;
        let mut i = 0;
        let mut heights = heights;
        heights.push(0);
        while i < heights.len() {
            if stack.is_empty() || heights[i] > heights[*stack.last().unwrap()] {
                stack.push(i);
                i += 1;
            } else {
                let h = heights[stack.pop().unwrap()];
                let w = if stack.is_empty() {
                    i
                } else {
                    i - stack.last().unwrap() - 1
                };
                max_area = max_area.max(h * w as i32);
            }
        }
        max_area
    }
}