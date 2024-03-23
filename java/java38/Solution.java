package java38;

class Solution {
    public String countAndSay(int n) {
        String s = "1";
        int i;
        for (i = 1; i < n; i++) {
            s = count(s);
        }
        return s;
    }

    public String count(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count);
                sb.append(s.charAt(i - 1));
                count = 1;
            }
        }
        sb.append(count);
        sb.append(s.charAt(s.length() - 1));
        return sb.toString();
    }
}