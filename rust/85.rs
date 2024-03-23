struct Solution;
impl Solution {
    pub fn maximal_rectangle(matrix: Vec<Vec<char>>) -> i32 {
        if matrix.is_empty() {
            return 0;
        }
        let mut width = vec![vec![0; matrix[0].len()]; matrix.len()];
        let mut height = vec![vec![0; matrix[0].len()]; matrix.len()];
        let mut boxes = vec![vec![vec![]; matrix[0].len()]; matrix.len()];
        let mut max_area = 0;
        for i in 0..matrix.len() {
            for j in 0..matrix[0].len() {
                if matrix[i][j] == '1' {
                    width[i][j] = if j == 0 { 1 } else { width[i][j-1] + 1 };
                    height[i][j] = if i == 0 { 1 } else { height[i-1][j] + 1 };
                }
            }
        }
        for i in 0..matrix.len() {
            for j in 0..matrix[0].len() {
                if matrix[i][j] == '1' {
                    if i == 0 && j == 0 {
                        boxes[i][j] = vec![(1,1)];
                    }
                    else if i == 0 {
                        boxes[i][j] = vec![(width[i][j],1)]
                    }
                    else if j == 0 {
                        boxes[i][j] = vec![(1,height[i][j])]
                    }
                    else {
                        boxes[i][j] = Self::makebox(boxes[i-1][j-1].clone(), width[i][j]-1, height[i][j]-1);
                    }
                    for thebox in &boxes[i][j] {
                        max_area = max_area.max((thebox.0 * thebox.1) as i32);
                    }
                }
            }
        }
        max_area as i32
    }
    pub fn makebox(last_boxes: Vec<(i32, i32)>, width: i32, height: i32) -> Vec<(i32, i32)> {
        let mut boxes: Vec<(i32, i32)> = vec![];
        boxes.push((width+1, 1));
        boxes.push((1, height+1));
        for last_box in last_boxes {
            if width > last_box.0 && height > last_box.1 {
                boxes.push((last_box.0+1, last_box.1+1));
            }
            else if width > last_box.0 {
                boxes.push((last_box.0+1, height+1));
            }
            else if height > last_box.1 {
                boxes.push((width+1, last_box.1+1));
            }
            else {
                boxes.push((width+1, height+1));
            }
        }
        boxes
    }
}

fn main() {
    let matrix = vec![
        vec!['0','0','1'],
        vec!['1','1','1'],
    ];
    println!("{}", Solution::maximal_rectangle(matrix));
}