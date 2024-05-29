package main

import (
	"math"
)

func computeArea(ax1 int, ay1 int, ax2 int, ay2 int, bx1 int, by1 int, bx2 int, by2 int) int {
	x := math.Min(float64(bx2-ax1), float64(ax2-bx1))
	x = math.Min(float64(ax2-ax1), x)
	x = math.Min(float64(bx2-bx1), x)
	x = math.Max(x, 0)
	y := math.Min(float64(by2-ay1), float64(ay2-by1))
	y = math.Min(float64(by2-by1), y)
	y = math.Min(float64(ay2-ay1), y)
	y = math.Max(y, 0)
	return (ax2-ax1)*(ay2-ay1) + (bx2-bx1)*(by2-by1) - int(x*y)
}

func main() {
	computeArea(0, 0, 0, 0, 0, 0, 0, 0)
}
