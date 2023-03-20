public class Test {
    public static void main(String[] args) {
        Triangles ts = new Triangles();

        ts.add(0,3, 0, 0, 4, 0);
        ts.add(0,1, 0, 0, 1, 0);
        ts.add(0,2, 0, 0, 2, 0);
        ts.nameStream().forEach(s -> System.out.println(s));
        System.out.println(ts.getTriangle());
    }
}
