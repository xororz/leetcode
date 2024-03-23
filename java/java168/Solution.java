package java168;

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber != 0) {
            res.append((char) ((columnNumber - 1) % 26 + 'A'));
            columnNumber -= res.charAt(res.length() - 1) - 'A' + 1;
            columnNumber /= 26;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(52));
    }
}