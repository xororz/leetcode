package main

import "math"

type heap struct {
	length int
	data   []int
}

func Heap() *heap {
	h := new(heap)
	h.length = 0
	h.data = []int{}
	return h
}

func (h *heap) add(num int) {
	h.data = append(h.data, num)
	idx := h.length
	h.length++
	for h.data[idx] < h.data[(idx-1)/2] && idx != 0 {
		h.data[idx], h.data[(idx-1)/2] = h.data[(idx-1)/2], h.data[idx]
		idx = (idx - 1) / 2
	}
}
func (h *heap) top() int {
	if h.length == 0 {
		return math.MinInt
	}
	return h.data[0]
}

func (h *heap) pop() int {
	res := h.data[0]
	h.data[0], h.data[h.length-1] = h.data[h.length-1], h.data[0]
	idx := 0
	l, r := idx*2+1, idx*2+2
	for l < len(h.data)-1 {
		if r < len(h.data)-1 {
			if h.data[idx] > h.data[l] || h.data[idx] > h.data[r] {
				if h.data[l] < h.data[r] {
					h.data[idx], h.data[l] = h.data[l], h.data[idx]
					idx = l
				} else {
					h.data[idx], h.data[r] = h.data[r], h.data[idx]
					idx = r
				}
			} else {
				break
			}
		} else {
			if h.data[idx] > h.data[l] {
				h.data[idx], h.data[l] = h.data[l], h.data[idx]
				idx = l
			} else {
				break
			}
		}
		l, r = idx*2+1, idx*2+2
	}
	h.length--
	h.data = h.data[:h.length]
	return res
}

type MedianFinder struct {
	hmax *heap
	hmin *heap
}

func Constructor() MedianFinder {
	res := new(MedianFinder)
	res.hmax = new(heap)
	res.hmin = new(heap)
	return *res
}

func (this *MedianFinder) AddNum(num int) {
	if num >= this.hmin.top() {
		this.hmin.add(num)
	} else {
		this.hmax.add(-num)
	}
	if this.hmax.length+1 < this.hmin.length {
		this.hmax.add(-this.hmin.pop())
	} else if this.hmax.length > this.hmin.length {
		this.hmin.add(-this.hmax.pop())
	}
}

func (this *MedianFinder) FindMedian() float64 {
	if this.hmin.length > this.hmax.length {
		return float64(this.hmin.top())
	} else {
		return float64((this.hmin.top() - this.hmax.top())) / 2
	}
}

func main() {
	obj := Constructor()
	obj.AddNum(1)
	print(obj.FindMedian())
	obj.AddNum(2)
	print(obj.FindMedian())
	obj.AddNum(3)
	print(obj.FindMedian())
	obj.AddNum(4)
	print(obj.FindMedian())
	obj.AddNum(5)
	print(obj.FindMedian())
	obj.AddNum(6)
	print(obj.FindMedian())
}
