import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        Fractions fractions = new Fractions(5);// this: prev + next = res
        fractions.setFrac(0, 1, 2);// 1/2 : 0 + 1/4 = 1/4
        fractions.setFrac(1, 1, 4);// 1/4 : 1/2 + 3/5 = 11/1-
        fractions.setFrac(2, 1, 5);// 3/5 : 1/4 + 2/5 = 13/20
        fractions.setFrac(3, 1, 4);// 2/5 : 3/5 + 1/8 = 29/40
        fractions.setFrac(4, 1, 8);// 1/8 : 2/5 + 0 = 2/5
        Iterator <Fractions> iter = fractions.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        System.out.println("\nNew iterator");
        fractions.setFrac(3, 2, 11);
        iter = fractions.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        System.out.println("\nNew iterator 2");
        fractions.setFrac(1, 4, 27);
        fractions.setFrac(2, 9, 14);
        fractions.setFrac(3, 7, 13);
        iter = fractions.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

    }
}
