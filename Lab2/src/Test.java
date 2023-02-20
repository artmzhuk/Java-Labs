public class Test {
    public static void main(String[] args) {
        BinaryNumber x = new BinaryNumber(255);
        BinaryNumber y = x.Add(new BinaryNumber(1));
        y.printBE();
    }
}
