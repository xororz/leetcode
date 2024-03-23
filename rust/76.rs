impl Solution {
    pub fn min_window(s: String, t: String) -> String {
        let m = s.len();
        let n = t.len();
        let s = s.as_bytes();
        let t = t.as_bytes();
        let mut need = vec![0; 128];
        let mut window = vec![0; 128];
        for i in 0..n {
            need[t[i] as usize] += 1;
        }
        let mut left = 0;
        let mut right = 0;
        let mut start = 0;
        let mut min_len = m + 1;
        let mut count = 0;
        while right < m {
            let c = s[right] as usize;
            right += 1;
            if need[c] > 0 {
                window[c] += 1;
                if window[c] <= need[c] {
                    count += 1;
                }
            }
            while count == n {
                if right - left < min_len {
                    start = left;
                    min_len = right - left;
                }
                let c = s[left] as usize;
                left += 1;
                if need[c] > 0 {
                    if window[c] <= need[c] {
                        count -= 1;
                    }
                    window[c] -= 1;
                }
            }
        }
        if min_len == m + 1 {
            "".to_string()
        } else {
            String::from_utf8(s[start..start + min_len].to_vec()).unwrap()
        }
    }
}