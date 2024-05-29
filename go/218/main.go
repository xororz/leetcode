package main

import (
	"fmt"
	"sort"
)

type building struct {
	h  int
	l  int
	r  int
	s1 []*building
	s2 []*building
	sl *side
	sr *side
}

func makebuild(l, r, h int) *building {
	res := new(building)
	res.l = l
	res.r = r
	res.h = h
	res.s1 = make([]*building, 0)
	res.s2 = make([]*building, 0)
	return res
}

type side struct {
	x    int
	p    *building
	next *side
}

func makeside(x int, p *building) *side {
	res := new(side)
	res.x = x
	res.p = p
	return res
}

func (s *side) isleft() bool {
	return s.x == s.p.l
}

func getSkyline(buildings [][]int) [][]int {
	sides := make([]*side, 0)
	builds := make([]*building, 0)
	for i := range buildings {
		build := makebuild(buildings[i][0], buildings[i][1], buildings[i][2])
		ls := makeside(build.l, build)
		rs := makeside(build.r, build)
		build.sl = ls
		build.sr = rs
		builds = append(builds, build)
		sides = append(sides, ls, rs)
	}
	sort.Slice(sides, func(i, j int) bool {
		if sides[i].x == sides[j].x {
			return sides[i].p.h < sides[j].p.h
		}
		return sides[i].x < sides[j].x
	})
	for i := 0; i < len(sides)-1; i++ {
		sides[i].next = sides[i+1]
	}
	for i := range sides {
		if sides[i].isleft() {
			b := sides[i].p
			for j := i + 1; j < len(sides); j++ {
				if sides[j].x > b.r {
					break
				}
				if sides[j].isleft() && sides[j].p.h >= b.h {
					b.s1 = append(b.s1, sides[j].p)
				} else if !sides[j].isleft() && sides[j].p.h > b.h {
					if sides[j].x == b.r {
						continue
					}
					sides[j].p.s2 = append(sides[j].p.s2, b)
				}
			}
		}
	}
	for i := range builds {
		if len(builds[i].s2) > 0 {
			b := builds[i].s2[0]
			for j := range builds[i].s2 {
				if builds[i].s2[j].h >= b.h {
					b = builds[i].s2[j]
				}
			}
			builds[i].s2 = []*building{b}
		}
	}
	res := make([][]int, 0)
	ss := sides[0]
	now := []int{ss.p.l, ss.p.h}
	res = append(res, []int{now[0], now[1]})
out:
	for {
		sb := ss.p
		for i := range sb.s1 {
			if sb.s1[i].l >= now[0] {
				ss = sb.s1[i].sl
				sb.s1 = sb.s1[i+1:]
				if now[1] != ss.p.h {
					if ss.p.l == now[0] {
						res = res[:len(res)-1]
					}
					now = []int{ss.p.l, ss.p.h}
					res = append(res, []int{now[0], now[1]})
				}
				continue out
			}
		}
		now[0] = ss.p.r
		if len(sb.s2) > 0 {
			ss = sb.s2[0].sl
			now[1] = ss.p.h
			res = append(res, []int{now[0], now[1]})
			continue
		}
		now[1] = 0
		res = append(res, []int{now[0], now[1]})
		if ss.p.sr.next == nil {
			break
		}
		ss = ss.p.sr.next
		now = []int{ss.p.l, ss.p.h}
		res = append(res, []int{now[0], now[1]})
	}
	return res
}

func main() {
	fmt.Println(getSkyline([][]int{
		// {2, 9, 10},
		// {3, 7, 15},
		// {5, 12, 12},
		// {15, 20, 10},
		// {19, 24, 8},
		// {0, 2, 3},
		// {2, 5, 3},
		// {2, 14, 4},
		// {4, 8, 8},
		// {6, 16, 4},
		// {4, 9, 10}, {4, 9, 15}, {4, 9, 12}, {10, 12, 10}, {10, 12, 8},
		{3, 7, 8}, {3, 8, 7}, {3, 9, 6}, {3, 10, 5}, {3, 11, 4}, {3, 12, 3}, {3, 13, 2}, {3, 14, 1},
	}))
}
