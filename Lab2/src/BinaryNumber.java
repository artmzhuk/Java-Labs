public class BinaryNumber {
    private final boolean[] number;

    public BinaryNumber(long longNumber) {
        int length = (int) (Math.log(longNumber) / Math.log(2));
        length++;
        number = new boolean[length];
        for (int i = 0; i < length; i++) {
            int bit = (int) ((longNumber >> i) & 1);
            number[i] = bit == 1;
        }
    }

    private BinaryNumber(boolean[] array) { //little endian
        this.number = array;
    }

    public BinaryNumber Add(BinaryNumber x) {
        boolean[] result = new boolean[Math.max(x.number.length, this.number.length) + 1];
        int over = 0;
        for (int i = 0; i < Math.max(x.number.length, this.number.length) || over != 0; i++) {
            int xI = 0;
            int thisI = 0;
            if (i < x.number.length && x.number[i]) {
                xI = 1;
            }
            if (i < this.number.length && this.number[i]) {
                thisI = 1;
            }
            int sum = xI + thisI + over;
            result[i] = (sum % 2 == 1);
            over = sum / 2;
            System.out.print(result[i] ? "1" : "0");
        }
        System.out.println();
        return new BinaryNumber(result);
    }

    public void printBE() {
        boolean isSkipping = true;
        for (int i = this.number.length - 1; i >= 0; i--) {
            if (isSkipping && !this.number[i]) {
                continue;
            } else if (this.number[i]) {
                isSkipping = false;
            }
            System.out.print(this.number[i] ? "1" : "0");
        }
        System.out.println();
    }
}
