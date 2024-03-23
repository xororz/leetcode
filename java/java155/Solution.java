package java155;

import java.util.Stack;

class MinStack {
    Stack<Integer> s = new Stack<>();
    Stack<Integer> m = new Stack<>();
    int mm = Integer.MAX_VALUE;

    public MinStack() {

    }

    public void push(int val) {
        mm = Math.min(mm, val);
        s.push(val);
        m.push(mm);
    }

    public void pop() {
        s.pop();
        m.pop();
        if (m.empty())
            mm = Integer.MAX_VALUE;
        else
            mm = m.lastElement();
    }

    public int top() {
        return s.lastElement();
    }

    public int getMin() {
        return m.lastElement();
    }
}