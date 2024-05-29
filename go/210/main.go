package main

import "fmt"

func findOrder(numCourses int, prerequisites [][]int) []int {
	cs := make([][]int, numCourses)
	requests := make([][]int, numCourses)
	for _, req := range prerequisites {
		course, pre := req[0], req[1]
		cs[course] = append(cs[course], pre)
		requests[pre] = append(requests[pre], course)
	}
	path := make([]int, 0)
	todo := make([]int, 0)
	for i := 0; i < numCourses; i++ {
		if len(cs[i]) == 0 {
			todo = append(todo, i)
		}
	}
	for _, i := range todo {
		makecourse(cs, requests, i, &path)
	}
	for i := 0; i < numCourses; i++ {
		if len(cs[i]) != 0 {
			return make([]int, 0)
		}
	}
	return path
}

func remove(l []int, t int) []int {
	for i := range l {
		if l[i] == t {
			return append(l[:i], l[i+1:]...)
		}
	}
	return l
}

func appendElement(slice *[]int, element int) {
	*slice = append(*slice, element)
}

func makecourse(cs [][]int, requests [][]int, course int, path *[]int) {
	appendElement(path, course)
	for _, pc := range requests[course] {
		cs[pc] = remove(cs[pc], course)
		if len(cs[pc]) == 0 {
			makecourse(cs, requests, pc, path)
		}
	}
}

func main() {
	prerequisites := [][]int{{1, 0}}
	fmt.Print(findOrder(2, prerequisites))
}
