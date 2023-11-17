import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    static class RollComparator implements Comparator<Student> {
        /* Helper class to compare rollnos of student objects. */

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getRollno() - o2.getRollno();
        }
    }

    static class NameComparator implements Comparator<Student> {
        /* Helper class to compare name values of student objects. */

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    public static void rollnoSort(ArrayList<Student> students) {
        /* Sorts the ArrayList by RollNo using the Bubble Sort Algorithm. */

        RollComparator comparator = new RollComparator();

        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.size() - 1; j++) {
                if (comparator.compare(students.get(j), students.get(j + 1)) > 0) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
    }

    public static void nameSort(ArrayList<Student> students) {
        /* Sorts the ArrayList by name using the Insert Sort Algorithm. */

        NameComparator comparator = new NameComparator();

        for (int i = 1; i < students.size(); i++) {
            int j = i;
            while (j > 0 && comparator.compare(students.get(j), students.get(j - 1)) < 0) {
                Student temp = students.get(j);
                students.set(j, students.get(j - 1));
                students.set(j - 1, temp);
                j--;
            }
        }
    }

    public static void main(String[] args) {

        // Array List to store student objects
        ArrayList<Student> studentRegister = new ArrayList<>();

        // Instantiate each student.
        Student s1 = new Student(5, "John Doe", "1234 Apple Street, Boulder, CO 80302");
        Student s2 = new Student(2, "Jane Smith", "5678 Cherry Lane, Denver, CO 80203");
        Student s3 = new Student(8, "Michael Johnson", "9101 Orange Drive, Pueblo, CO 81001");
        Student s4 = new Student(4, "Emily Davis", "1112 Peach Avenue, Fort Collins, CO 80521");
        Student s5 = new Student(1, "David Williams", "1314 Plum Court, Colorado Springs, CO 80903");
        Student s6 = new Student(6, "Sarah Brown", "1516 Pear Way, Grand Junction, CO 81501");
        Student s7 = new Student(7, "Daniel Jones", "1718 Lemon Circle, Durango, CO 81301");
        Student s8 = new Student(3, "Jessica Miller", "1920 Lime Blvd, Aspen, CO 81611");
        Student s9 = new Student(9, "Matthew Wilson", "2122 Grape Street, Vail, CO 81657");
        Student s10 = new Student(10, "Ashley Moore", "2324 Berry Lane, Estes Park, CO 80517");

        // Add each student to the ArrayList studentRegister.
        studentRegister.add(s1);
        studentRegister.add(s2);
        studentRegister.add(s3);
        studentRegister.add(s4);
        studentRegister.add(s5);
        studentRegister.add(s6);
        studentRegister.add(s7);
        studentRegister.add(s8);
        studentRegister.add(s9);
        studentRegister.add(s10);

        // Printing out the Array un-sorted.
        System.out.println("The unsorted Register is: ");
        for (Student item : studentRegister) {
            System.out.println(item.toString());
        }

        // Printing out the Array sorted by Rollno.
        System.out.println("The Register sorted by Roll Number is: ");
        rollnoSort(studentRegister);
        for (Student value : studentRegister) {
            System.out.println(value.toString());
        }

        // Printing out the Array sorted by name.
        System.out.println("The Register sorted by Name is: ");
        nameSort(studentRegister);
        for (Student student : studentRegister) {
            System.out.println(student.toString());
        }
    }
}