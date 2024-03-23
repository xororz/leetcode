package java166;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long p = numerator, q = denominator;
        if (p % q == 0)
            return Long.toString(p / q);
        int zhengfu;
        if (p < 0) {
            p = -p;
            if (q > 0) {
                zhengfu = -1;
            } else {
                q = -q;
                zhengfu = 1;
            }
        } else {
            if (q > 0) {
                zhengfu = 1;
            } else {
                q = -q;
                zhengfu = -1;
            }
        }
        long base = 0;
        if (p > q) {
            base = p / q;
            p %= q;
        }
        Map<Long, Integer> m = new HashMap<>();
        List<String> l = new ArrayList<>();
        int i = 0;
        while (p != 0) {
            p *= 10;
            if (m.containsKey(p)) {
                break;
            }
            long chu = p / q;
            l.add(Long.toString(chu));
            m.put(p, i);
            p %= q;
            i++;
        }
        String zhengshu = Long.toString(base);
        if (zhengfu == -1)
            zhengshu = "-" + zhengshu;
        if (p == 0) {
        } else {
            l.add(m.get(p), "(");
            l.add(")");
        }
        return zhengshu + "." + String.join("", l);
    }

    public static void main(String[] args) {
        String s = new Solution().fractionToDecimal(-1, -2147483648);
        System.out.println(s);
    }
}