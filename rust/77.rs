struct Solution;
impl Solution {
    pub fn combine(n: i32, k: i32) -> Vec<Vec<i32>> {
        let mut res = vec![];
        let mut path = vec![];
        Self::dfs(1, n, k, &mut path, &mut res);
        res
    }
    fn dfs(start: i32, n: i32, k: i32, path: &mut Vec<i32>, res: &mut Vec<Vec<i32>>) {
        if k == 0 {
            res.push(path.clone());
            return;
        }
        for i in start..=n - k + 1 {
            path.push(i);
            Self::dfs(i + 1, n, k - 1, path, res);
            path.pop();
        }
    }
}

fn main() {
    println!("{:?}", Solution::combine(10, 5));
}