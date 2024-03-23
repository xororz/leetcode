package java149;

import java.util.Objects;

public class Pair {
    public double k, b;

    public Pair(double k, double b) {
        this.k = k;
        this.b = b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(k, b);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Pair pair = (Pair) obj;
        return Double.compare(pair.k, k) == 0 && Double.compare(pair.b, b) == 0;
    }
}
