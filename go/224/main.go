package main

type item struct {
	op  byte
	num int
}

func makeitem(op byte, num int) item {
	i := new(item)
	i.num = num
	i.op = op
	return *i
}

func calculate(s string) int {
	stack := make([]item, 0)
	ss := make([]item, 0)
	for i := range s {
		if s[i] == ' ' {
			continue
		}
		if '0' <= s[i] && s[i] <= '9' {
			top := len(ss) - 1
			if top+1 > 0 {
				if ss[top].op == ' ' {
					ss[top].num = ss[top].num*10 + int(s[i]) - '0'
					continue
				}
			}
			ss = append(ss, makeitem(' ', int(s[i])-'0'))
		} else {
			ss = append(ss, makeitem(s[i], 0))
		}
	}
	for i := range ss {
		op := ss[i].op
		if op == '+' || op == '-' || op == '(' {
			stack = append(stack, ss[i])
		} else {
			num := 0
			if op == ')' {
				num = stack[len(stack)-1].num
				stack = stack[:len(stack)-2]
			} else {
				num = ss[i].num
			}
			{
				top := len(stack) - 1
				if top == -1 {
					stack = append(stack, makeitem(' ', num))
					continue
				}
				if stack[top].op == '+' {
					stack[top-1].num += num
					stack = stack[:top]
				} else if stack[top].op == '-' {
					if top == 0 {
						stack[top].op = ' '
						stack[top].num = -num
						continue
					}
					if stack[top-1].op == ' ' {
						stack[top-1].num -= num
						stack = stack[:top]
					} else {
						stack[top].op = ' '
						stack[top].num = -num
					}
				} else {
					stack = append(stack, ss[i])
				}
			}
		}
	}
	return stack[0].num
}

func main() {
	print(calculate("(1+(4+5+2)-3)+(6+8)"))
}
