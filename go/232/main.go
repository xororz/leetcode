package main

type MyQueue struct {
	len int
	s1  []int
	s2  []int
}

func Constructor() MyQueue {
	q := new(MyQueue)
	q.len = 0
	q.s1 = make([]int, 0)
	q.s2 = make([]int, 0)
	return *q
}

func (this *MyQueue) Push(x int) {
	this.len++
	this.s1 = append(this.s1, x)
}

func (this *MyQueue) Pop() int {
	if len(this.s2) > 0 {
		l := this.s2[len(this.s2)-1]
		this.s2 = this.s2[:len(this.s2)-1]
		this.len--
		return l
	} else {
		for i := range this.s1 {
			this.s2 = append(this.s2, this.s1[this.len-i-1])
		}
		this.s1 = make([]int, 0)
		l := this.s2[len(this.s2)-1]
		this.s2 = this.s2[:len(this.s2)-1]
		this.len--
		return l
	}
}

func (this *MyQueue) Peek() int {
	if len(this.s2) > 0 {
		return this.s2[len(this.s2)-1]
	} else {
		return this.s1[0]
	}
}

func (this *MyQueue) Empty() bool {
	return this.len == 0
}

func main() {
	obj := Constructor()
	obj.Push(1)
	obj.Push(1)
	obj.Push(1)
	obj.Push(1)
	obj.Pop()
	obj.Push(1)
	obj.Pop()
	obj.Pop()
	obj.Pop()
	obj.Pop()
}
