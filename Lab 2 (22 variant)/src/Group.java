import java.util.Arrays;

public class Group {
    private Student[] students;
    private int numOfStudents;
    private int studentsAdded;

    public static class Student {
        private final String name;
        private final int id;
        private final int points;
        private int mark;

        public Student(String name, int points, int id) {
            this.name = name;
            this.points = points;
            this.id = id;
        }
    }

    private int comparePoints(Student student1, Student student2) {
        return Integer.compare(student1.points, student2.points);
    }

    public void sortByPoints() {
        Arrays.sort(students, this::comparePoints);
    }

    private void setMarks() {
        int length = this.students.length;
        for (int i = length - 1; i >= 0; i--) {
            if (i + 1 > length * 3 / 4) {
                this.students[i].mark = 5;
            } else if (i + 1 > length / 2) {
                this.students[i].mark = 4;
            } else if (i + 1 > length / 4) {
                this.students[i].mark = 3;
            } else {
                this.students[i].mark = 2;
            }
        }
    }

    public Group(int numOfStudents) {
        this.students = new Student[numOfStudents];
        this.numOfStudents = numOfStudents;
        this.studentsAdded = 0;
    }

    public int getMark(int id) {
        for (int i = 0; ; i++) {
            if (this.students[i].id == id) {
                return this.students[i].mark;
            }
        }
    }
    public int getMark(String name){
        for (int i = 0; ; i++) {
            if (this.students[i].name.equals(name)) {
                return this.students[i].mark;
            }
        }
    }

    public void addStudent(String name, int points) {
        int initialLength = this.students.length;
        if (this.studentsAdded < this.numOfStudents) {
            students[studentsAdded] = new Student(name, points, studentsAdded);
            studentsAdded++;
        } else {
            Student[] newStudents = new Student[initialLength + 1];
            System.arraycopy(this.students, 0, newStudents, 0, initialLength);
            newStudents[initialLength] = new Student(name, points, initialLength);
            this.students = newStudents;
            this.studentsAdded++;
            this.numOfStudents++;
        }
        if (studentsAdded == numOfStudents){
            this.sortByPoints();
            this.setMarks();
        }

    }
}

/*
*        /* Scanner myObj = new Scanner(System.in);
        myObj.useDelimiter("\\s");
        System.out.println("Insert information about " + numOfStudents + " students in this format\n " +
                "Name Points");
        for (int i = 0; i < numOfStudents; i++) {
            String name = myObj.next();
            int points = Integer.parseInt(myObj.next());
            students[i] = new Student(name, points, i);
        }
        myObj.close();

           this.sortByPoints();
        this.setMarks();
        */