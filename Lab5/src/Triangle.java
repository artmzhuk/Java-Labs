public class Triangle {
    int a1, a2, b1, b2, c1, c2, id;
    double area;
    double gip;

    public Triangle(int a1, int a2, int b1, int b2, int c1, int c2, int id) {
        this.a1 = a1;
        this.a2 = a2;
        this.b1 = b1;
        this.b2 = b2;
        this.c1 = c1;
        this.c2 = c2;
        this.id = id;
        this.area = this.area();
        this.gip = this.getGip();
    }


    public boolean isSquared() {
        double alen, blen, clen;
        alen = Math.pow((double) (this.a1 - this.b1), 2) + Math.pow((double) (this.a2 - this.b2), 2);
        blen = Math.pow((double) (this.b1 - this.c1), 2) + Math.pow((double) (this.b2 - this.c2), 2);
        clen = Math.pow((double) (this.c1 - this.a1), 2) + Math.pow((double) (this.c2 - this.a2), 2);
        if (alen + blen == clen) {
            return true;
        } else {
            return false;
        }
    }

    public double getGip() {
        double result = Math.max(Math.pow((double) (this.c1 - this.a1), 2) + Math.pow((double) (this.c2 - this.a2), 2),
                Math.pow((double) (this.a1 - this.b1), 2) + Math.pow((double) (this.a2 - this.c2), 2));
        result = Math.max(result,
                Math.pow((double) (this.b1 - this.c1), 2) + Math.pow((double) (this.b2 - this.c2), 2));
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.a1 + "," + this.a2 + " " + this.b1 + "," + this.b2
                + " " + this.c1 + "," + this.c2);
        return result.toString();
    }

    public double area() {
        double alen, blen, clen;
        alen = Math.pow((double) (this.a1 - this.b1), 2) + Math.pow((double) (this.a2 - this.b2), 2);
        blen = Math.pow((double) (this.b1 - this.c1), 2) + Math.pow((double) (this.b2 - this.c2), 2);
        clen = Math.pow((double) (this.c1 - this.a1), 2) + Math.pow((double) (this.c2 - this.a2), 2);
        alen = Math.sqrt(alen);
        blen = Math.sqrt(blen);
        clen = Math.sqrt(clen);
        double perim = alen + blen + clen;
        perim /= 2;
        double area = Math.sqrt(perim * (perim - alen) * (perim - blen) * (perim - clen));
        return area;
    }
}
