package java50;

import java.util.Stack;

class Solution {
    public double myPow(double x, int n) {
        long nn = n;
        if (x == 1)
            return x;
        if (x == -1) {
            if (nn % 2 == 0)
                return 1;
            return -1;
        }
        if (nn == 0)
            return 1;
        double ans = 1;
        if (nn < 0) {
            nn = -nn;
            x = 1 / x;
        }
        long s = 1;
        double xs = x;
        Stack<Double> st = new Stack<>();
        st.add(1.);
        while (s <= nn) {
            st.add(xs);
            xs *= xs;
            s *= 2;
        }
        xs = st.pop();
        s /= 2;
        while (nn > 0) {
            if (nn >= s) {
                ans *= xs;
                nn -= s;
            }
            xs = st.pop();
            s /= 2;
        }
        return ans;
    }

    public static void main(String args[]) {
        s50 s = new s50();
        System.out.println(s.myPow(2, -2147483648));
    }
}