package main

import "strconv"

type tree struct {
	Val  int
	Next map[int]*tree
}

func canFinish(numCourses int, prerequisites [][]int) bool {
	print(strconv.Itoa(numCourses) + "is useless")
	dekiru := make(map[int]bool)
	m := make(map[int]*tree)
	for i := range prerequisites {
		course, pre := prerequisites[i][0], prerequisites[i][1]
		dekiru[course] = false
		dekiru[pre] = false
		_, ok := m[pre]
		if !ok {
			nt := new(tree)
			nt.Val = pre
			nt.Next = make(map[int]*tree)
			m[pre] = nt
		}
		mc, ok := m[course]
		if !ok {
			nt := new(tree)
			nt.Val = course
			nt.Next = make(map[int]*tree)
			nt.Next[pre] = m[pre]
			m[course] = nt
		} else {
			mc.Next[pre] = m[pre]
		}
	}
	for _, t := range m {
		if !finish(t, dekiru, nil, 0) {
			return false
		}
	}
	return true
}

func finish(course *tree, dekiru map[int]bool, depth map[int]int, newdep int) bool {
	if depth == nil {
		depth = make(map[int]int)
	}
	if dekiru[course.Val] {
		return true
	}
	dep, ok := depth[course.Val]
	if ok {
		if dep != newdep {
			return false
		}
	} else {
		depth[course.Val] = newdep
	}
	for _, k := range course.Next {
		if !finish(k, dekiru, depth, newdep+1) {
			return false
		}
	}
	dekiru[course.Val] = true
	return true
}

func main() {
	prerequisites := [][]int{{0, 1}, {0, 2}, {1, 2}}
	print(canFinish(0, prerequisites))
}
