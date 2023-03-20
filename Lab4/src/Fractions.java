import java.util.Iterator;
import java.util.NoSuchElementException;

public class Fractions implements Iterable {
    public Fraction[] fractions;

    Fractions(int n) {
        this.fractions = new Fraction[n];
        for (int i = 0; i < n; i++) {
            this.fractions[i] = new Fraction(0, 1);
        }
    }

    public void setFrac(int pos, int num, int denom) {
        this.fractions[pos].num = num;
        this.fractions[pos].denom = denom;
    }

    public Fraction getFrac(int pos) {
        return fractions[pos];
    }

    public Iterator iterator() {
        return new FractionsIterator();
    }

    private class Fraction {
        int num;
        int denom;

        Fraction(int num, int denom) {
            this.num = num;
            this.denom = denom;
        }

        public String toString() {
            StringBuilder result = new StringBuilder();
            result.append(this.num + "/" + this.denom);
            return result.toString();
        }

        private int gcdByEuclidsAlgorithm(int n1, int n2) {
            if (n2 == 0) {
                return n1;
            }
            return gcdByEuclidsAlgorithm(n2, n1 % n2);
        }

        public void simplify() {
            int gcd = gcdByEuclidsAlgorithm(this.num, this.denom);
            this.num /= gcd;
            this.denom /= gcd;
        }
    }

    private class FractionsIterator implements Iterator {
        private int pos = 0;
        public boolean hasNext() {
            return pos < fractions.length;
        }

        public Fraction next() {
            Fraction prevF, nextF;
            if (pos > 0) {
                prevF = fractions[pos - 1];
            } else {
                prevF = new Fraction(0, 1);
            }
            if (pos < fractions.length - 1) {
                nextF = fractions[pos + 1];
            } else {
                nextF = new Fraction(0, 1);
            }
            int resD = nextF.denom * prevF.denom;
            int resN = (prevF.num * (resD / prevF.denom)) + (nextF.num * (resD / nextF.denom));
            pos++;

            Fraction res = new Fraction(resN, resD);
            res.simplify();
            return res;
        }
    }
}
