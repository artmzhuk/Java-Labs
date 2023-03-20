/*по сравнению с отчётом была пофикшен баг в 22-23 строках(в неправильном вызове конструктора)*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class Triangles {
    HashMap<Integer, Triangle> Table;
    int total;

    Triangles() {
        Table = new HashMap<>();
        total = 0;
    }

    void add(Triangle t) {
        Table.put(total, t);
        total++;
    }

    void add(int a1, int a2, int b1, int b2, int c1, int c2) {
        Table.put(total, new Triangle(a1, a2, b1, b2, c1, c2, total));
        total++;
    }

    /*1. порождение потока, содержащего прямоугольные треугольники из
последовательности, гипотенуза каждого из которых превышает гипотенузу
предыдущего прямоугольного треугольника последовательности; */
    public Stream<Triangle> nameStream() {
        ArrayList<Triangle> result = new ArrayList<>();
        AtomicReference<Double> prevPr = new AtomicReference<>((double) 0);
        Table.entrySet().stream()
                .filter(x -> x.getValue().isSquared())
                .forEach(x -> {
                    if (x.getValue().gip > prevPr.get()) {
                        result.add(x.getValue());
                    }
                    prevPr.set(x.getValue().gip);
                });

        return result.stream();
    }

    /*2. вычисление максимальной площади среди площадей прямоугольных
треугольников, входящих в последовательность. */
    public Optional<Integer> getTriangle() {
        ArrayList<Double> result = new ArrayList<>();
        Table.entrySet()
                .stream()
                .filter(x -> x.getValue().isSquared())
                .forEach(x -> result.add(x.getValue().area));
        int id = Table.entrySet().stream().max((entry1, entry2) -> entry1.getValue().area > entry2.getValue().area() ? 1 : -1).get().getKey();
        Optional<Integer> resultO = Optional.empty();
        resultO = Optional.of(id);
        return resultO;
    }
}

