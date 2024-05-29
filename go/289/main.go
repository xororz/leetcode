package main

import "fmt"

func getNeighbors(board [][]int, i, j int) int {
	m, n := len(board), len(board[0])
	res := 0
	for x := -1; x < 2; x++ {
		for y := -1; y < 2; y++ {
			if i+x >= 0 && i+x < m && j+y >= 0 && j+y < n && x*y+x+y != 0 {
				res += board[i+x][j+y] % 2
			}
		}
	}
	return res
}

func gameOfLife(board [][]int) {
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[0]); j++ {
			neighbors := getNeighbors(board, i, j)
			if board[i][j] == 1 && (neighbors == 2 || neighbors == 3) {
				board[i][j] += 2

			}
			if board[i][j] == 0 && neighbors == 3 {
				board[i][j] += 2
			}
		}
	}
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[0]); j++ {
			board[i][j] /= 2
		}
	}
}

func main() {
	board := [][]int{
		{0, 1, 0},
		{0, 0, 1},
		{1, 1, 1},
		{0, 0, 0},
	}
	gameOfLife(board)
	fmt.Println(board)
}
