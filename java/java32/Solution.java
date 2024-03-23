package java32;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int longestValidParentheses(String s) {
        int i;
        int ans = 0;
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int diff = 0;
        int last = -1;
        int end = n - 1;
        for (i = 0; i < n; ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    if (diff > ans) {
                        ans = diff;
                    }
                    diff = 0;
                    last = i;
                } else {
                    diff += 2;
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) {
            if (diff > ans) {
                ans = diff;
            }
            return ans;
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            if (end - idx > ans) {
                ans = end - idx;
            }
            end = idx - 1;
        }
        if (end - last > ans) {
            ans = end - last;
        }
        return ans;
    }

    public static void main(String[] args) {
        s32 sol = new s32();
        String s = "(())()(()((";
        System.out.println(sol.longestValidParentheses(s));
    }
}