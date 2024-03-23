package java150;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (String c : tokens) {
            if (Character.isDigit(c.charAt(c.length() - 1))) {
                int v = Integer.parseInt(c);
                s.add(v);
            } else {
                int b = s.pop();
                int a = s.pop();
                switch (c) {
                    case "+":
                        s.add(a + b);
                        break;
                    case "-":
                        s.add(a - b);
                        break;
                    case "*":
                        s.add(a * b);
                        break;
                    case "/":
                        s.add(a / b);
                        break;
                }
            }
        }
        return s.lastElement();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] tokens = { "4", "13", "5", "/", "+" };
        System.out.println(s.evalRPN(tokens));
    }
}