package main

func maximalSquare(matrix [][]byte) int {
	m := len(matrix)
	n := len(matrix[0])
	res := make([][]int, m)
	ans := 0
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if i == 0 {
				if j == 0 {
					if matrix[0][0] == '1' {
						res[0] = append(res[0], 1)
						ans = max(ans, res[i][j]*res[i][j])
					} else {
						res[0] = append(res[0], 0)
					}
				} else {
					if matrix[i][j] == '1' {
						res[0] = append(res[0], 1)
						ans = max(ans, res[i][j]*res[i][j])
					} else {
						res[0] = append(res[0], 0)
					}
				}
			} else {
				if j == 0 {
					if matrix[i][j] == '1' {
						res[i] = append(res[i], 1)
						ans = max(ans, res[i][j]*res[i][j])
					} else {
						res[i] = append(res[i], 0)
					}
				} else {
					if matrix[i][j] == '1' {
						res[i] = append(res[i], min(res[i-1][j-1], res[i][j-1], res[i-1][j])+1)
						ans = max(ans, res[i][j]*res[i][j])
					} else {
						res[i] = append(res[i], 0)
					}
				}
			}
		}
	}
	return ans
}

func main() {
	board := [][]byte{
		{'1', '0', '1', '0', '0'},
		{'1', '0', '1', '1', '1'},
		{'1', '1', '1', '1', '1'},
		{'1', '0', '0', '1', '0'},
	}
	print(maximalSquare(board))
}
