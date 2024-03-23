package java125;

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                sb.append(s.charAt(i));
            }
        }
        String ns = sb.toString();
        ns = ns.toLowerCase();
        for (int i = 0; i < ns.length() / 2; i++) {
            if (ns.charAt(i) != ns.charAt(ns.length() - 1 - i))
                return false;
        }
        return true;
    }
}