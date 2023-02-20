public class Test {
    public static void main(String[] args) {
        Group iu9 = new Group(4);
        iu9.addStudent("Artem", 5);
        iu9.addStudent("Vlad", 10);
        iu9.addStudent("Shodi", 30);
        iu9.addStudent("Matvey", 4);
        System.out.println(iu9.getMark("Artem"));
        iu9.addStudent("Katya", 11);
        iu9.addStudent("Sveta", 12);
        iu9.addStudent("Gulnara", 13);
        System.out.println(iu9.getMark(0));
        System.out.println(iu9.getMark("Gulnara"));

    }
}
