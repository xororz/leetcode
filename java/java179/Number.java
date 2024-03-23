package java179;

public class Number implements Comparable<Number> {
    public String num;

    public Number(int n) {
        num = "" + n;
    }

    public Number(String n) {
        num = n;
    }

    @Override
    public int compareTo(Number number) {
        int n1 = num.length();
        int n2 = number.num.length();
        if (n1 < n2) {
            for (int i = 0; i < n1; i++) {
                if (num.charAt(i) != number.num.charAt(i)) {
                    return num.charAt(i) - number.num.charAt(i);
                }
            }
            return this.compareTo(new Number(number.num.substring(n1, n2)));
        } else if (n1 == n2) {
            for (int i = 0; i < n1; i++) {
                if (num.charAt(i) != number.num.charAt(i)) {
                    return num.charAt(i) - number.num.charAt(i);
                }
            }
            return 0;
        } else {

            for (int i = 0; i < n2; i++) {
                if (num.charAt(i) != number.num.charAt(i)) {
                    return num.charAt(i) - number.num.charAt(i);
                }
            }
            return new Number(num.substring(n2, n1)).compareTo(number);
        }
    }
}
